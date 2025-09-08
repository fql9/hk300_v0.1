package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. 启用 CORS 支持，并应用我们下面定义的 corsConfigurationSource
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // 2. 禁用 CSRF (Cross-Site Request Forgery) 保护。
                // 对于前后端分离的无状态 API (如 REST API)，通常需要禁用它。
                .csrf(csrf -> csrf.disable())

                // 3. 配置请求授权规则
                .authorizeHttpRequests(authz -> authz
                        // 允许所有对 /api/** 路径的请求，无需身份验证
                        .requestMatchers("/api/**").permitAll()
                        // 其他所有请求都需要身份验证 (如果您的应用还有其他路径)
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 4. 设置允许的来源 (这里必须是您 Flutter Web 应用的准确地址)
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:1806"));

        // 5. 设置允许的 HTTP 方法
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 6. 设置允许的请求头
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // 7. 是否允许发送 Cookie 等凭证信息
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用这个 CORS 配置
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}