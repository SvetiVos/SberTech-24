package com.example.repositories;

import org.springframework.stereotype.Repository;
import com.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}