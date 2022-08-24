package com.example.week7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserRegistrationDto {



    @NotBlank(message = "fullName is required")
    private String firstName;

    @NotBlank(message = "fullName is required")
    private String lastName;


    @NotBlank(message = "username is required")
    private String username;

    @Column(unique = true)
    private String email;

    @NotBlank(message = "password is required")
    private String password;
}
