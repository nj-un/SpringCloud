package com.gx.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${spring.application.name}")
    String applicationName;


    @RequestMapping("/hello")
    public String home(@RequestParam String email) {
        LOGGER.info("[email] - [{}]",email);
        return "My Name's :" + applicationName + " Email:" + email;
    }
}
