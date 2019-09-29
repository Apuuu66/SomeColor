package com.guier.validator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class WW {
    @Test
    public void te() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("https://www.baidu.com/", String.class);
        System.out.println(forObject);
    }
}
