package com.example.services;

import com.example.repositories.CartRepository;
import com.example.repositories.ProductCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.models.Product;
import com.example.models.Cart;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductCartRepository productCartRepository;

    public Cart createCart() {
        Cart cart = new Cart();
        cart.setPromoCode("uuu555");
        return cartRepository.save(cart);
    }

    public int addProductToCart(int id, int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        cart.getProducts().add(product);
        cartRepository.save(cart);
        return product.getId();
    }

    public boolean removeProductFromCart(int cartId, int id) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        if (cart.getProducts().remove(product)) {
            cartRepository.save(cart);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void purchaseProducts(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            int newQuantity = product.getQuantity() - 1;
            if (newQuantity < 0) {
                throw new RuntimeException("Недостаточно товара на складе");
            }
            product.setQuantity(newQuantity);
            productRepository.save(product);
        }
        clearCart(cartId);
    }

    public List<Product> getProductsInCart(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getProducts();
    }

    public void clearCart(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getProducts().clear();
        cartRepository.save(cart);
    }

}
