package com.example.springboot.controller;

import com.example.springboot.interfaces.XXService;
import com.example.springboot.task.Task2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @Autowired
    Task2 task2;

    @GetMapping("/hello")
    @XXService
    public String hello() {
        return "123";
    }

    @GetMapping("/async")
    public void async() throws Exception {
        task2.doTaskOne();
        task2.doTaskTwo();
        task2.doTaskThree();
    }

}
