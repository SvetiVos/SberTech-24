package com.example.services;

import com.example.repositories.CartRepository;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    private CartRepository cartRepository;

    public long createCart() {
        return cartRepository.createCart();
    }

    public int addProductToCart(int id, int cartId) {
        return cartRepository.addProductToCart(id, cartId);
    }

    public boolean removeProductFromCart(int cartId, int id) {
        return cartRepository.removeProductFromCart(cartId, id);
    }

}
