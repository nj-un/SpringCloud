package com.gx.feign.client;

import com.gx.feign.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "feign-hello")
public interface HelloClient {

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/hello")
//    String findStudentByName(@RequestParam("name") String name);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/hello")
    Student findStudentByName(@RequestParam("name") String name, @RequestHeader(name = "token", required = false) String token);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/hello")
    Student addStudent(@RequestBody Student student);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/hello/{studentId}")
    Student editStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/hello/{studentId}")
    void deleteStudent(@PathVariable("studentId") Long studentId);
}
