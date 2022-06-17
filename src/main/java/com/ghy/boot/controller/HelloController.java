package com.ghy.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/艾弗森.webp")
    public String hello(){
        return "aaa";
    }
}
