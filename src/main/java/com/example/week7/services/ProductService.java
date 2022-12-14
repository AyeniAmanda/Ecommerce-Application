package com.example.week7.services;

import com.example.week7.dto.ProductDto;
import com.example.week7.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();

    public Product findProductById(Long id);


    public Product saveProduct(Product product);

    public Product updateProduct(Product product);


    public Boolean deleteProductById(Long id);

    Product productDtoToEntity(ProductDto productDto);

}
