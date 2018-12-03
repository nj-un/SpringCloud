package com.gx.feign.controller;

import com.gx.feign.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hi")
public class HelloController {

    @Autowired
    HelloClient helloClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String find(@RequestParam("name") String name) {
        return "Hi," + helloClient.findStudentByName(name);
    }
}
