package com.example.week7.repository;

import com.example.week7.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long>{

    List<WishList> findAllByCustomerId(Long CustomerId);



}


