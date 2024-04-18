package com.example.springkatte.users.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "LoginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "LogoutPage";
    }
    
}
