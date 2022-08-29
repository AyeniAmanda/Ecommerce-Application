package com.example.week7.controller;

import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.User;
import com.example.week7.services.ProductService;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping
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
        return "login";
    }
    @PostMapping("/process_register")
    public String processRegister(UserRegistrationDto userRegistrationDto) {
        userService.saveCustomer(userRegistrationDto);
        return "signUpSuccess";
    }
    @GetMapping("/fill-form")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }
    @PostMapping("/login2")
    public String Signup(@ModelAttribute User user, HttpSession session) {
        String message = userService.userSignIn(user.getEmail(), user.getPassword());
        ///System.out.println("=======message is " + message );
        if(message.equals("customer")){
            System.out.println("Customer logged in");
            session.setAttribute("email" , user.getEmail());
            return "redirect:/display";
        } else if (message.equals("admin")) {
            System.out.println("Admin logged in");
            session.setAttribute("email" , user.getEmail());
            return "redirect:/admin/dashboard";
        }else{
            return "login";
        }
    }

    @GetMapping("/display")
    public String display(Model model){
        model.addAttribute("displayProducts" , service.getAll());
        //System.out.println("display");
        return "displayPage";
    }

//    @GetMapping("/users")
//    public String listUsers (Model model){
//        List<User> listUsers = userService.getAllCustomer();
//        model.addAttribute("listUsers", listUsers);
//        return "users";
//    }
    @GetMapping("/contact")
    public String contactPage () {
        return "contact";
    }
}
