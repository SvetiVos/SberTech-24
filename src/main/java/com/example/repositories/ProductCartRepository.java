package com.example.repositories;

import org.springframework.stereotype.Repository;
import com.example.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
}