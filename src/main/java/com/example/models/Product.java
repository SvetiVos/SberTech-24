package com.example.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
}
