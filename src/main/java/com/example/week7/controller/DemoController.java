//package com.example.week7.controller;
//
//import com.example.week7.model.User;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/demo")
//public class DemoController {
//
//    @GetMapping("")
//    public String index(){
//        return "home page";
//    }
//
//    @GetMapping("/add/{first}/{second}")
//    public String add(@PathVariable("first") int a, @PathVariable("second") int b){
//        int sum = a + b;
//        return "sum of " + a + " and " + b + " is " + sum;
//    }
//
//    @GetMapping("/subtract/{first}/{second}")
//    public String sub(@PathVariable("first") int a, @PathVariable("second") int b){
//        int difference = a - b;
//        return "difference of " + a + " and " + b + " is " + difference;
//    }
//    @PostMapping
//    public String createUser(@RequestBody User user){
//        System.out.println("user is " + user);
//        return "user successfully created";
//    }
//}
