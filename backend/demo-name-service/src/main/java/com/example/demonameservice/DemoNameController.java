package com.example.demonameservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoNameController {

    @GetMapping("/api/name")
    public Map<String, String> getName() {
        // 在真实场景中，这可能会从数据库或配置中读取
        return Map.of("name", "Microservice");
    }
}