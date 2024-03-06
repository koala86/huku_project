package com.namu.huku_spring.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    
    @GetMapping("/index")
    public String index() {
        String nowTime = LocalDateTime.now().toString();
        return "good" + nowTime;
    }
}
