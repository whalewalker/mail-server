package com.example.mailservice.web.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "*", maxAge = 3600)
public class MailServerController {
    @GetMapping()
    public @ResponseBody String Home(){
        return "<h1> Hello World </h1>";
    }
}
