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
@Table(name ="user")
public class User implements Serializable {
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

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

    @Enumerated(EnumType.STRING)
    private Role role;

}
