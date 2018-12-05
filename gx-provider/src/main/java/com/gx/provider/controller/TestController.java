package com.gx.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/hello")
    public String hello() {
        return "My Name's :" + applicationName + " Email:1837307557@qq.com";
    }
}
