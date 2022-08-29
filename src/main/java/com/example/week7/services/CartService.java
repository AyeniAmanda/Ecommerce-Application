package com.example.week7.services;

import com.example.week7.model.Cart;

import java.util.List;

public interface CartService {

    public void addToCart(Cart cartEntry);

    public List<Cart> getCustomerCartById(Long customerId);

    public void deleteCartContentById(Long cartId);

    public void updateCart(Long id);

    public void downgradeCart(Long id);
}
