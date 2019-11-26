package com.example.springboot.controller;

import com.example.springboot.interfaces.XXService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @GetMapping("/hello")
    @XXService
    public String hello() {
        return "123";
    }
}
