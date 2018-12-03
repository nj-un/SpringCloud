package com.gx.consul.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    String applicationName;

    @RequestMapping("/hello")
    public String home(@RequestParam String email) {
        return "My Name's :" + applicationName + " Email:" + email;
    }
}
