package com.example.week7.services;

import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.model.Product;
import com.example.week7.model.User;
import com.example.week7.repository.UserRepository;

import java.util.List;

public interface UserService {

    public List<User> getAllCustomer();

    public User saveProduct(UserRegistrationDto registrationDto);

       public User saveAdmin(UserRegistrationDto registrationDto);

       public User findByCustomerEmail(String email);

       public User findByAdminEmail(String email);

}
