package com.example.llmfortune.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "HOME OK";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

//aaa