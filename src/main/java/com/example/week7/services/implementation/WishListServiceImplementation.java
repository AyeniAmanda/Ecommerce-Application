package com.example.week7.services.implementation;

import com.example.week7.model.WishList;
import com.example.week7.repository.WishListRepository;
import com.example.week7.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WishListServiceImplementation implements WishListService {

    private WishListRepository wishListRepo;

    @Autowired
    public WishListServiceImplementation(WishListRepository wishListRepo) {
        this.wishListRepo = wishListRepo;
    }

     @Override
    public List<WishList> getCustomerWishList(Long id) {
        List<WishList> wishLists = wishListRepo.findAllByCustomerId(id);
        return wishLists;
    }
    @Override
    public void addToWishList(Long productId, Long customerId, String productName) {
        WishList newWishlist = new WishList();
        newWishlist.setProductName(productName);
        newWishlist.setCustomerId(customerId);
        newWishlist.setProductId(productId);
        newWishlist.setDate(new Date());
        wishListRepo.save(newWishlist);
    }
    @Override
    public void deleteWishlistContentById(Long wishlistId) {
        wishListRepo.deleteById(wishlistId);
    }
}


