package com.guier.exceptions.controller;

import com.guier.exceptions.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
    @GetMapping("/testException")
    public String testException() throws Exception {
        System.out.println(11342);
        if (true) {
            throw new Exception("Exception");
        }
        return "沙雕";
    }

    @GetMapping("/testCustomException")
    public String testCustomException() {

        if (true) {
            throw new CustomException("CustomException");
        }
        return "沙雕";
    }

    @GetMapping("/testRuntimeException")
    public String testRuntimeException() {
        if (true) {
            throw new RuntimeException("RuntimeException");
        }
        return "沙雕";
    }

    @GetMapping("/testArithmeticException")
    public String testArithmeticException() {
        int x = 1 / 0;
        System.out.println(x);
        return "沙雕";
    }

    @ExceptionHandler(RuntimeException.class)
    public String rr(RuntimeException e) {
        return "RuntimeException";
    }

    @ExceptionHandler(CustomException.class)
    public String ce(CustomException e) {
        return "CustomException" + e.getMessage();
    }
}
