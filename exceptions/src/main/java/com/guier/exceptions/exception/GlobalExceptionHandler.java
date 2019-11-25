package com.guier.exceptions.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ArithmeticException.class)
    public HashMap arithmeticExceptionHandler(HttpServletRequest req, ArithmeticException e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("exception", e.getMessage());
        map.put("url", req.getRequestURI());
        map.put("handler", "ArithmeticException");
        return map;
    }
    @ExceptionHandler(value = Exception.class)
    public HashMap exceptionHandler(HttpServletRequest req, Exception e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("exception", e.getMessage());
        map.put("url", req.getRequestURI());
        map.put("handler", "Exception");
        return map;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public HashMap runtimeExceptionHandler(HttpServletRequest req, RuntimeException e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("exception", e.getMessage());
        e.printStackTrace();
        map.put("url", req.getRequestURI());
        map.put("handler", "RuntimeException");
        return map;
    }




    @ExceptionHandler(value = CustomException.class)
    public HashMap customExceptionHandler(HttpServletRequest req, CustomException e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("exception", e.getMessage());
        map.put("url", req.getRequestURI());
        map.put("handler", "CustomException");
        return map;
    }
}
