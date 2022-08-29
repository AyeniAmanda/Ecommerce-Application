package com.example.week7.services.implementation;

//import com.example.week7.dto.CartItemDto;
import com.example.week7.dto.ProductDto;
import com.example.week7.dto.UserLoginDto;
import com.example.week7.dto.UserRegistrationDto;
import com.example.week7.exception.UserNotFoundException;
//import com.example.week7.model.Cart;
import com.example.week7.model.Product;
import com.example.week7.model.Role;
import com.example.week7.model.User;
//import com.example.week7.repository.CartRepository;
import com.example.week7.repository.ProductRepository;
import com.example.week7.repository.UserRepository;
import com.example.week7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    CartRepository cartRepository;

    @Autowired
    private UserRegistrationDto userRegistrationDto;





    @Override
    public User saveCustomer(UserRegistrationDto registrationDto) {
        return userRepository.save(customerDtoToEntity(registrationDto));
    }


    @Override
    public User saveAdmin(UserRegistrationDto registrationDto) {
        return userRepository.save(adminDtoToEntity(registrationDto));
    }


    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("This user was not found"));

            return user;
        }



//    @Override
//    public User findByAdminEmail(String email) {
//        User user = userRepository.findByEmail(email);
//       if(user == null){
//           System.out.println("User not found");
//           return null;
//
//       }
//        return user;
//    }


    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }


    @Override
    public User saveProduct(UserRegistrationDto registrationDto) {
        return null;
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




    @Override
    public String userSignIn(String email, String password) {
        // first find User by email
        String message = "";
        User user = findByEmail(email);
        if (user.getPassword().equals(password)){
            if (user.getRole() == Role.ADMIN){
                message = "admin";
            } else if (user.getRole() == Role.CUSTOMER) {
                message = "customer";
            }
        }else{
            message = "Incorrect Password";
        }

        return message;
    }

//    public Cart addItemToCart(Product product, int quantity, User user) {
//        if(user.getRole() == Role.CUSTOMER) {
//            Cart cart = user.getCart;
//            if (cart == null) {
//                cart = new Cart();
//            }
//            Set<CartItemDto> cartItems = cart.getCartItem();
//            CartItem cartItem = findCartItem(cartItems, product.getProductId());
//            if (cartItems == null) {
//                cartItems = new HashSet<>();
//                if (cartItem == null) {
//                    cartItem = new CartItem();
//                    cartItem.setProduct(product);
//                    cartItem.setTotalPrice(quantity * product.getPrice());
//                    cartItem.setQuantity(quantity);
//                    cartItem.setCart(cart);
//                    cartItems.add(cartItem);
//                    itemRepository.save(cartItem);
//                }
//            } else {
//                if (cartItem == null) {
//                    cartItem = new CartItem();
//                    cartItem.setProduct(product);
//                    cartItem.setTotalPrice(quantity * product.getPrice());
//                    cartItem.setQuantity(quantity);
//                    cartItem.setCart(cart);
//                    cartItems.add(cartItem);
//                    itemRepository.save(cartItem);
//                } else {
//                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
//                    cartItem.setTotalPrice(cartItem.getTotalPrice() + (quantity * product.getPrice()));
//                    itemRepository.save(cartItem);
//                }
//            }
//            cart.setCartItem(cartItems);
//            int totalItems = totalItems(cart.getCartItem());
//            double totalPrice = totalPrice(cart.getCartItem());
//            cart.setTotalPrice(totalPrice);
//            cart.setTotalItems(totalItems);
//            cart.setUser(user);
//            return (Cart) cartRepository.save(cart);
//        }







    }
