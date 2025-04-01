package com.tutorial.msfirstapplication.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") 
public class UserController {

    @Value("${spring.application.name}")
    private String app_name;
    
    @GetMapping
    public String home() {
        System.out.println("request");
        System.out.println(app_name);
        return "Hello Alex";
    }
}