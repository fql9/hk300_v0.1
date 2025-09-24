package com.example.demogreetingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class DemoGreetingController {

    @Autowired
    private RestTemplate restTemplate;

    // 这是 name-service 在 Docker 网络中的地址。
    // "name-service" 是我们在 docker-compose.yml 中定义的服务名。
    // 8081 是 name-service 监听的端口。
    private final String nameServiceUrl = "http://name-service:8081/api/name";

    @GetMapping("/api/greeting")
    public Map<String, String> getGreeting() {
        // 调用 name-service
        Map<String, String> nameResponse = restTemplate.getForObject(nameServiceUrl, Map.class);
        String name = nameResponse != null ? nameResponse.getOrDefault("name", "Default Name") : "Default Name";

        // 组合最终的问候语
        return Map.of("greeting", "Hello, " + name);
    }
}