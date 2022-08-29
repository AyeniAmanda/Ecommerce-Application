package com.example.week7.services.implementation;

import com.example.week7.dto.ProductDto;
import com.example.week7.model.Product;
import com.example.week7.repository.ProductRepository;
import com.example.week7.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImplementation implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct( Product product) {
        return productRepository.save(product);
    }
    @Override
    public Boolean deleteProductById(Long id) {
        if (findProductById(id) == null) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product productDtoToEntity(ProductDto productDto){
        Product product1 = new Product();
        product1.setProductName(productDto.getProductName());
        product1.setPrice(productDto.getProductPrice());
        product1.setProductQuantity(productDto.getProductQty());
        product1.setProductDesc(productDto.getProductDesc());
        product1.setProductCategory(productDto.getProductCategory());
        return product1;
    }
}
