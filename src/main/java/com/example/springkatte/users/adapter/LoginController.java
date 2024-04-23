package com.example.springkatte.users.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
