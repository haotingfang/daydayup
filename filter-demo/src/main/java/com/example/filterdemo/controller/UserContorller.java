package com.example.filterdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContorller {

    @GetMapping("/user")
    public String getAllUser(@RequestParam(value = "source", required = false) String source) {
        return "用户列表";
    }
}
