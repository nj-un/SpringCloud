package com.gx.feignhello.controller;

import com.gx.feignhello.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/hello")
public class TestController {

    static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    HttpServletRequest request;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Student findStudentByName(@RequestParam("name") String name, @RequestParam(name = "token", required = false) String token) {
        // return "挽歌- My Name's" + name;
        LOGGER.info("[查询参数] - [{}]", name);
        LOGGER.info("[Token] - [{}]", token);
        LOGGER.info("[Auth] - [{}]", request.getHeader("Auth"));
        return new Student(1L, "挽歌-GET", "1837307557@qq.com");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        LOGGER.info("[添加信息] - [{}]", student.toString());
        return new Student(2L, "挽歌-SAVA", "1837307557@qq.com");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{studentId}")
    public Student editStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
        LOGGER.info("[修改信息] - [{}]", student.toString());
        return new Student(3L, "挽歌-EDIT", "1837307557@qq.com");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        LOGGER.info("[根据编号删除学生] - [{}]", studentId);
    }
}
