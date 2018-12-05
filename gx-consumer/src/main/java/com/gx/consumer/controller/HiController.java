package com.gx.consumer.controller;

import com.gx.consumer.service.HiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    static Logger logger = LoggerFactory.getLogger(HiController.class);

    @Autowired
    HiService hiService;

    @GetMapping
    public String hi() {
        return hiService.hello();
    }
}
