@echo off
:: =================================================================
:: Design Tokens Sync Script (Windows Batch - ASCII-Safe Version)
:: This script uses only built-in Windows tools and contains no
:: special characters to avoid encoding issues.
:: =================================================================

echo.
echo [INFO] Starting design tokens sync (using Windows Batch script)...
echo.

:: --- Configuration Section (Modify your information here) ---
set "GITHUB_PAT=你的GitHub_Personal_Access_Token"
set "REPO=你的GitHub用户名/my-app-design-tokens"
set "TOKEN_FILE_PATH=tokens.json"
set "OUTPUT_DIR=design_tokens"
:: --- End of Configuration Section ---


:: Combine the output file path
set "OUTPUT_FILE_PATH=%OUTPUT_DIR%\%TOKEN_FILE_PATH%"

:: 1. Check configuration
if "%GITHUB_PAT%"=="你的GitHub_Personal_Access_Token" (
    echo [ERROR] Please set the GITHUB_PAT variable in scripts/sync_tokens.bat
    exit /b 1
)

:: 2. Ensure the output directory exists
if not exist "%OUTPUT_DIR%" (
    echo [INFO] Creating directory: %OUTPUT_DIR%
    mkdir "%OUTPUT_DIR%"
)

:: 3. Download the token file from GitHub
echo [INFO] Downloading token file from GitHub...
curl -L -s -f -H "Authorization: token %GITHUB_PAT%" -H "Accept: application/vnd.github.v3.raw" -o "%OUTPUT_FILE_PATH%" "https://api.github.com/repos/%REPO%/contents/%TOKEN_FILE_PATH%"

:: Check if curl command was successful
if %errorlevel% neq 0 (
    echo [ERROR] Token file download failed!
    echo [ERROR] Please check if your GITHUB_PAT, REPO name, and TOKEN_FILE_PATH are correct.
    exit /b 1
)
echo [SUCCESS] Token file downloaded successfully to: %OUTPUT_FILE_PATH%
echo.

:: 4. Run the figma2flutter code generator
echo [INFO] Running `dart run figma2flutter` to generate code...
dart run figma2flutter
if %errorlevel% neq 0 (
    echo [ERROR] `dart run figma2flutter` command failed.
    exit /b 1
)
echo [SUCCESS] `figma2flutter` executed successfully.
echo.

:: 5. Format the generated code
echo [INFO] Formatting the generated code...
dart format lib/generated/ lib/theme/
echo.

:: 6. All done
echo [SUCCESS] Design tokens sync completed successfully!
echo.