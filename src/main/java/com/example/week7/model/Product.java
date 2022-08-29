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
    private Long product_Id;
    private String productDesc;

    private double price;

    private int productQuantity;

    private  String productName;

    private String productCategory;

    private String image;

    public Product(String productDesc, double price, int productQuantity, String productName, String productCategory, String image) {
        this.productDesc = productDesc;
        this.price = price;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productCategory = productCategory;
        this.image = image;
    }
}
