package com.gx.feignhello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/hello")
public class TestController {

    @ResponseStatus(HttpStatus.OK)
    public String findStudentByName(@RequestParam("name") String name) {
        return "挽歌- My Name's" + name;
    }
}