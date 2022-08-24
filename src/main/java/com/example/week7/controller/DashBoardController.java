package com.example.week7.controller;

import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.User;
import com.example.week7.repository.UserRepository;
import com.example.week7.services.ProductService;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

public class DashBoardController {
    @Autowired
    protected ProductService productService;

    @Autowired
    protected UserService userService;





    @GetMapping(value = "/admin")
    public String index(Model model) throws IOException {
        model.addAttribute("totalProduct", productService.getAll().size());
        model.addAttribute("totalUser", userService.getAllCustomer().size());
        return "admin/dashboard/index";
    }

}
