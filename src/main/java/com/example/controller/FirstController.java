package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FirstController {
    @GetMapping("/")
    public String newHTML() {
        return "newHTML";
    }
}