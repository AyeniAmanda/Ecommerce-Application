package com.example.week7.controller;


import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.User;
import com.example.week7.services.ProductService;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "admin" )
public class AdminController {

    @Autowired
    private final UserService userService;

    @Autowired
    private  ProductService service;

    @Autowired
    private  UserRegistrationDto registrationDto;

    public AdminController(UserService userService, ProductService service) {
        this.userService = userService;
        this.service = service;
    }

    @GetMapping( value="/register")
    public String registerPage(Model model){
        model.addAttribute("admin" , new UserRegistrationDto());
        return "Admin2/register";
    }


    @PostMapping(value="/registerAdmin")
    public String registerAdmin(@ModelAttribute UserRegistrationDto admin ){
        userService.saveAdmin(admin);
        return "redirect:/admin/loginAdmin";
    }

    @GetMapping( value="/login")
    public String loginPage(Model model){
        model.addAttribute("loggedInAdmin" , new UserRegistrationDto());
        return "Admin2/login";
    }



    @GetMapping( value="/dashboard")
    public String dashboard(Model model , HttpSession session){
        List<Product> productList = service.getAll();
        String email = (String) session.getAttribute("email");
        User admin = userService.findByEmail(email);
        model.addAttribute("admin" , new User());
        model.addAttribute("products" , productList);
        model.addAttribute("id" , admin.getUserId());
        model.addAttribute("product" , new Product());
        model.addAttribute("productField" , new Product());

        if(session.getAttribute("email") == null){
            return "redirect:/admin/loginAdmin";
        }else {
            return "Admin2/dashboard";
        }
    }

    @GetMapping(value = "/getProduct/{productId}")
    public String getProduct(@PathVariable(name="productId") String productId , Model model){
        Long id = Long.parseLong(productId);
        System.out.println(service.findProductById(id));
        model.addAttribute("product" , service.findProductById(id));
        return "Admin2/product";
    }

    @GetMapping(value = "/editProduct/{productId}")
    public String editProduct(@PathVariable(name="productId") String productId , Model model){
        Long id = Long.parseLong(productId);
        // System.out.println(adminService.findProductById(id));
        model.addAttribute("product" , service.findProductById(id));
        model.addAttribute("productField" , new Product());
        return "Admin2/editProduct";
    }

    @PostMapping(value = "/editProduct")
    public String adminEditProduct(@ModelAttribute Product product , Model model){
        System.out.println(product);
        service.updateProduct(product);
        return "redirect:/admin/dashboard";
    }



    @PostMapping(value = "/addProduct")
    public String addProduct(@ModelAttribute Product product){
        service.saveProduct(product);
        return "redirect:/admin/dashboard";
    }

    @PostMapping(value = "/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable(name="productId") String productId){
        Long id = Long.parseLong(productId);
        service.deleteProductById(id);
        return "redirect:/admin/dashboard";
    }





}
