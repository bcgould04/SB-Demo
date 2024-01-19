package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${coach.name}")
    private String name;

    @GetMapping("/test")
    public String testConnection() {
        return "Testing " + name + " Narftastic!";
    }

}
