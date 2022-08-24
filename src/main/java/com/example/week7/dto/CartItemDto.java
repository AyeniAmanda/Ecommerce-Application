package com.example.week7.dto;

import com.example.week7.model.Cart;
import com.example.week7.model.Product;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Integer id;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    @Autowired
    private Cart cart;

   public CartItemDto(Cart cart ){
       this.setId(cart.getId());
       this.setQuantity(cart.getQuantity());
       this.setProduct(cart.getProduct());
   }
}
