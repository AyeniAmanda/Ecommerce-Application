package com.example.week7.controller;

import com.example.week7.model.User;
import com.example.week7.model.WishList;
import com.example.week7.services.ProductService;
import com.example.week7.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

public class WishListController {

    private WishListService wishListService;
    private ProductService productService;


    @Autowired
    public WishListController(WishListService wishListService, ProductService productService) {
        this.wishListService = wishListService;
        this.productService = productService;
    }

    @GetMapping("/wishList")
    public String displayCustomerCart(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        List<WishList> customerWishLists = wishListService.getCustomerWishList(loggedUser.getUserId());
        model.addAttribute("wishList", customerWishLists);
        return "wishList";
    }

    @GetMapping("/like/{productId}")
    public String addToWishlist(@PathVariable("productId") Long productId, Model model, HttpSession session) {
       // Product likedProduct = productService.getPr(productId);
        User loggedUser = (User) session.getAttribute("loggedUser");
       // wishListService.addToWishList(productId, loggedUser.getUserId(), likedProduct.getProductName());
        model.addAttribute("message", "product successfully added to wishList");
        return "redirect:/wishList";
    }

    @GetMapping("/unlike/{wishlistId}")
    public String updateWishList(@PathVariable("wishlistId") Long wishlistId) {
        wishListService.deleteWishlistContentById(wishlistId);
        return "redirect:/wishList";
    }
}
