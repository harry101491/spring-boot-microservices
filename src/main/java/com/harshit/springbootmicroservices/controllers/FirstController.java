package com.harshit.springbootmicroservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstController {

    @GetMapping("first")
    public String firstMethod() {
        return "Welcome to Microservices";
    }
}