# Contributing to Swiftour

First off, thank you for considering contributing to Swiftour! It's people like you that make our community and this project thrive. Your contributions are invaluable to us. ❤️

This document provides a set of guidelines for contributing to Swiftour. These are mostly guidelines, not strict rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

We welcome all forms of contributions, including but not limited to:

-   Reporting bugs
-   Suggesting new features or enhancements
-   Writing or improving documentation
-   Submitting code fixes or new features
-   Participating in community discussions

---

## Table of Contents

-   [Code of Conduct](#code-of-conduct)
-   [How Can I Contribute?](#how-can-i-contribute)
    -   [Reporting Bugs](#reporting-bugs)
    -   [Suggesting Enhancements](#suggesting-enhancements)
    -   [Your First Code Contribution](#your-first-code-contribution)
-   [Getting Started: Development Setup](#getting-started-development-setup)
-   [Pull Request Process](#pull-request-process)
    1.  [Fork the Repository](#1-fork-the-repository)
    2.  [Create a Feature Branch](#2-create-a-feature-branch)
    3.  [Make Your Changes](#3-make-your-changes)
    4.  [Adhere to Coding Standards](#4-adhere-to-coding-standards)
    5.  [Commit Your Changes](#5-commit-your-changes)
    6.  [Sync Your Branch with Main](#6-sync-your-branch-with-main)
    7.  [Push to Your Fork](#7-push-to-your-fork)
    8.  [Create a Pull Request](#8-create-a-pull-request)
-   [Pull Request Review Process](#pull-request-review-process)
-   [Style Guides](#style-guides)
    -   [Git Commit Messages](#git-commit-messages)
    -   [Code Formatting](#code-formatting)

---

## Code of Conduct

This project and everyone participating in it is governed by the **[Project Name] Code of Conduct**. By participating, you are expected to uphold this code. Please read our **[CODE_OF_CONDUCT.md](./CODE_OF_CONDUCT.md)** to understand the standards we expect.

## How Can I Contribute?

### Reporting Bugs

If you encounter a bug, please first search the [Issues page] to see if it has already been reported.

-   **If the bug hasn't been reported**, please [create a new issue]. Use a clear and descriptive title. In the body, provide as much detail as possible, including:
    -   **Steps to Reproduce**: A clear, step-by-step guide on how to trigger the bug.
    -   **Expected Behavior**: What you expected to happen.
    -   **Actual Behavior**: What actually happened. Include error messages, logs, screenshots, or screen recordings.
    -   **Your Environment**: Your operating system, browser version, [Project Name] version, etc.

-   **If the bug has already been reported**, you can add more information to the existing issue (e.g., how to reproduce it in a different environment) or subscribe to it to stay updated on its progress.

### Suggesting Enhancements

We love new ideas! If you have a suggestion for a new feature or an improvement to an existing one, please submit it via the [Issues page].

-   Use the "Feature Request" template if one is available.
-   Clearly explain the problem your enhancement solves and why it would be valuable to most users.
-   Provide use cases or design mockups to help us better understand your idea.

### Your First Code Contribution

Unsure where to begin contributing to [Project Name]? You can start by looking through `good first issue` and `help wanted` issues:

-   **[Good First Issues]** - issues which should only require a few lines of code, and a test or two.
-   **[Help Wanted Issues]** - issues which are a bit more involved than `good first issue`s.

If you plan to work on a major new feature, **please open an issue to discuss it first**. This ensures your work aligns with the project's goals and prevents wasted effort.


## Pull Request Process

#### 1. Fork the Repository

Click the "Fork" button at the top-right corner of the repository's page.

#### 2. Create a Feature Branch

Create a new branch from `main` (or `develop`) for your changes. Use a descriptive branch name, such as `fix/login-button-bug` or `feat/user-profile-page`.

```bash
# Switch to the main branch
git checkout main

# Pull the latest changes from the upstream repository
git pull upstream main

# Create and switch to your new branch
git checkout -b feat/add-user-profile-page