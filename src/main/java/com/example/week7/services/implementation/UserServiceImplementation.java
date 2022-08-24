package com.example.week7.services.implementation;

import com.example.week7.dto.ProductDto;
import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.Role;
import com.example.week7.model.User;
import com.example.week7.repository.ProductRepository;
import com.example.week7.repository.UserRepository;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRegistrationDto userRegistrationDto;





    @Override
    public User saveProduct(UserRegistrationDto registrationDto) {
        return userRepository.save(customerDtoToEntity(registrationDto));
    }


    @Override
    public User saveAdmin(UserRegistrationDto registrationDto) {
        return userRepository.save(adminDtoToEntity(registrationDto));
    }


    @Override
    public User findByCustomerEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            System.out.println("User not found");
            return null;
        }
        return user;
    }


    @Override
    public User findByAdminEmail(String email) {
        User user = userRepository.findByEmail(email);
       if(user == null){
           System.out.println("User not found");
           return null;

       }
        return user;
    }


    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

    public User customerDtoToEntity(UserRegistrationDto registrationDtO){
        User customer = new User();
        customer.setFirstName(registrationDtO.getFirstName());
        customer.setLastName(registrationDtO.getLastName());
        customer.setEmail(registrationDtO.getEmail());
        customer.setUsername(registrationDtO.getUsername());
        customer.setPassword(registrationDtO.getPassword());
        customer.setRole(Role.CUSTOMER);

        return customer;
    }


    public User adminDtoToEntity(UserRegistrationDto registrationDto){
        User admin = new User();
        admin.setFirstName(registrationDto.getFirstName());
        admin.setLastName(registrationDto.getLastName());
        admin.setEmail(registrationDto.getEmail());
        admin.setUsername(registrationDto.getUsername());
        admin.setPassword(registrationDto.getPassword());
        admin.setRole(Role.ADMIN);
        return admin;
    }

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