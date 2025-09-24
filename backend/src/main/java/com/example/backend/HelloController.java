package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 一个简单的 REST 控制器
 */
@RestController
public class HelloController {

    /**
     * 处理对 /hello 端点的 GET 请求
     * @param name 一个可选的请求参数
     * @return 一个包含问候信息的 Map 对象，它将被自动序列化为 JSON
     */
    @GetMapping("/hello")
    public Map<String, String> sayHello(@RequestParam(name = "name", defaultValue = "World") String name) {
        return Map.of("message", "Hello, " + name + "!");
    }

    /**
     * Actuator 会自动提供 /actuator/health 端点，我们这里只是为了演示
     * 你可以访问 http://localhost:8080/actuator/health 查看健康状态
     */
}