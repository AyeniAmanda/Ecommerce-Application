package com.example.week7.services;

import com.example.week7.model.WishList;

import java.util.List;

public interface WishListService {
    public List<WishList> getCustomerWishList(Long id);

    public void addToWishList(Long productId, Long customerId, String productName);

    public void deleteWishlistContentById(Long wishlistId);
}
