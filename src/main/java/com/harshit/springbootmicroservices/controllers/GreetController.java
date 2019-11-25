package com.harshit.springbootmicroservices.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Value("${message.default.welcome}")
    private String welcomeMessage;

    @Value("${message.default.goodbye}")
    private String goodByeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return this.welcomeMessage;
    }

    @GetMapping("/goodbye")
    public String goodBye() {
        return this.goodByeMessage;
    }
}