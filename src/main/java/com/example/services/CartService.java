package com.example.services;

import com.example.repositories.CartRepository;
import com.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.models.Product;
import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public long createCart() {
        return cartRepository.createCart();
    }

    public int addProductToCart(int id, int cartId) {
        return cartRepository.addProductToCart(id, cartId);
    }

    public boolean removeProductFromCart(int cartId, int id) {
        return cartRepository.removeProductFromCart(cartId, id);
    }

    @Transactional
    public void purchaseProducts(int cartId) {
        List<Product> products = getProductsInCart(cartId);
        for (Product product : products) {
            int newQuantity = product.getQuantity() - 1;
            if (newQuantity < 0) {
                throw new RuntimeException("Недостаточно товара на складе");
            }
            productRepository.updateProductQuantity(product.getId(), newQuantity);
        }
        clearCart(cartId);
    }

    public List<Product> getProductsInCart(int cartId) {
        return cartRepository.getProductsInCart(cartId);
    }

    public void clearCart(int cartId) {
        return cartRepository.clearCart(cartId);
    }
}
