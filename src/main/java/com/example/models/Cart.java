package com.example.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class Cart {
    private int cartId;
    private List<Product> products;
    private String promoCode;
}