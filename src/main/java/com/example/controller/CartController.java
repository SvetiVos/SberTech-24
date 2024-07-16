package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.services.CartService;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public long createCart() {
        return cartService.createCart();
    }

    @PostMapping("/cart/{cartId}/add")
    public int addProductToCart(@RequestBody int id, @PathVariable int cartId) {
        return cartService.addProductToCart(id, cartId);
    }

    @DeleteMapping("/cart/{cartId}/remove/{id}")
    public boolean removeProductFromCart(@PathVariable int cartId, @PathVariable int id) {
        return cartService.removeProductFromCart(cartId, id);
    }

    @PutMapping("/pay/{cartId}")
    public void pay(@PathVariable int cartId) {
        cartService.purchaseProducts(cartId);
    }
}