package com.gx.feignhello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/hello")
public class TestController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String findStudentByName(@RequestParam("name") String name) {
        return "挽歌- My Name's" + name;
    }
}
