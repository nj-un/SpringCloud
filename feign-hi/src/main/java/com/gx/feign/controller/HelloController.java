package com.gx.feign.controller;

import com.gx.feign.client.HelloClient;
import com.gx.feign.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hi")
public class HelloController {

    static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloClient helloClient;

    //    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public String find(@RequestParam("name") String name) {
//        return "Hi," + helloClient.findStudentByName(name);
//    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Student find(@RequestParam("name") String name, @RequestHeader(name = "token", required = false) String token) {
        LOGGER.info("[Token] - [{}]", token);
        return helloClient.findStudentByName(name, token);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student add(@RequestBody Student student) {
        return helloClient.addStudent(student);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{studentId}")
    public Student edit(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
        return helloClient.editStudent(student, studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        helloClient.deleteStudent(studentId);
    }
}
