package com.example.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}


