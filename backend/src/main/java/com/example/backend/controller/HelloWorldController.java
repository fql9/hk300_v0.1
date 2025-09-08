package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    /**
     * 将 GET 请求映射到 /api/hello 路径。
     * 注意：我们不再需要在这里使用 @CrossOrigin 注解，
     * 因为跨域问题将由全局的 SecurityConfig 统一处理。
     */
    // @CrossOrigin(origins = "http://localhost:1806")  <-- 移除或注释掉这一行
    @GetMapping("/api/hello")
    public Map<String, String> sayHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World from a Secure Spring Boot Backend!");
        return response;
    }
}