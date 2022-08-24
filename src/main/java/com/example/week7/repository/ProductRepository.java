package com.example.week7.repository;

import com.example.week7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    public Product findProductById(Product product);
//    public Product saveProduct(Product product);


}
