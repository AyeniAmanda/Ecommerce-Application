package com.example.week7.controller;

import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.User;
import com.example.week7.repository.UserRepository;
import com.example.week7.services.ProductService;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService service;
    @GetMapping("")
    public String viewHomePage(Model model) {
        List<Product> displayProducts = service.getAll();
        model.addAttribute("displayProducts", displayProducts);
        return "index";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @GetMapping("/login")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

//    @GetMapping("")
//    public String viewHomePage(Model model) {
//        List<Product> displayProducts = service.getAll();
//        model.addAttribute("displayProducts", displayProducts);
//        return "index";
//    }

    @PostMapping("/process_register")
    public String processRegister(UserRegistrationDto registrationDto) {
        userService.saveAdmin(registrationDto);


        return "signUpSuccess";
    }

//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> listUsers = service.getAll();
//        model.addAttribute("listUsers", listUsers);
//        return "users";
//    }
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
