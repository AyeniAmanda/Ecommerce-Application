package com.example.week7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_table")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productDesc;

    @NotBlank(message = "price is required")
    private double price;

    @NotBlank(message = "Quantity is required")
    private int productQuantity;

    @NotBlank(message = "product name is required")
    private  String productName;

    @NotBlank(message = "product category is required")
    private String productCategory;

}
