package com.inha.fabricApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }
}
