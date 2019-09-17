package com.guier;

import com.guier.po.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = User.builder().age(1).birthday(new Date()).build();
        System.out.println();
    }
}
