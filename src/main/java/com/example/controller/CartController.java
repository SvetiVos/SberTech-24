package com.example.controller;

import com.example.models.Product;
import com.example.models.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.example.services.CartService;
import com.example.services.ClientService;
import java.lang.String;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> read() {
        final List<Cart> carts = cartService.readAll();

        return carts != null &&  !carts.isEmpty()
                ? new ResponseEntity<>(carts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cart/{cartId}/add")
    public ResponseEntity<?> addProductToCart(@PathVariable int cartId, @RequestBody Product product) {
        cartService.addProductToCart(cartId, product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{cartId}/remove/{id}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable int cartId, @PathVariable int id) {
        final boolean deleted = cartService.removeProductFromCart(cartId, id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/cart/{cartId}/update/{id}")
    public ResponseEntity<?> updateProductQuantityInCart(@PathVariable int cartId, @PathVariable int id, @RequestParam int quantity) {
        final boolean updated = cartService.updateProductQuantityInCart(cartId, id, quantity);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/cart/pay")
    public ResponseEntity<?> pay(@PathVariable int clientId, @PathVariable String promoCode) {
        final boolean payd = cartService.pay(clientId, promoCode);
        return payd
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}