package com.example.week7.repository;

import com.example.week7.dto.UserDto;
import com.example.week7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //@Query("from User where email=?1")
    public User findByEmail(String email);


   // @Query("from User where email=?1 and password=?2")
   // public User findByUsernamePassword(String username,String password);


}
