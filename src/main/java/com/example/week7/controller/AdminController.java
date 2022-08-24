package com.example.week7.controller;


import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.User;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
    //@Component
    //@RequestMapping("/process_register")
    public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String viewHomePage(Model model) {
        return "admin/dashboard/index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "1signUp";
    }



    @PostMapping("/1process_register")
    public String processRegister(UserRegistrationDto registrationDto) {
        userService.saveAdmin(registrationDto);


        return "1signUpSuccess";
    }
    }

