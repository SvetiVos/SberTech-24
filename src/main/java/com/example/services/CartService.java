package com.example.services;


import com.example.models.Cart;
import com.example.services.ProductService;
import com.example.services.ClientService;
import com.example.models.Client;
import com.example.models.Product;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartService {

    private static final Map<Integer, Cart> CART_REPOSITORY_MAP = new HashMap<>();

    private static final Integer CART_ID_HOLDER = 0;

    private static final Map<Integer, Product> PRODUCT_REPOSITORY_MAP = new HashMap<>();

    private static final Integer PRODUCT_ID_HOLDER = 0;


    public List<Cart> readAll() {
        return new ArrayList<>(CART_REPOSITORY_MAP.values());
    }

    public void createCart(Cart cart) {
        final int cartIdHolder = CART_ID_HOLDER + 1;
        cart.setCartId(cartIdHolder);
        CART_REPOSITORY_MAP.put(cartIdHolder, cart);
    }

    public void addProductToCart(int cartId, Product product) {
        final int productId = PRODUCT_ID_HOLDER + 1;
        product.setId(productId);
        Cart cart = CART_REPOSITORY_MAP.get(cartId);
        List<Product> products = cart.getProducts();
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        cart.setProducts(products);
    }

    public boolean updateProductQuantityInCart(int cartId, int id, int quantity) {
        Cart cart = CART_REPOSITORY_MAP.get(cartId);
        if (cart != null) {
            List<Product> products = cart.getProducts();
            for (Product product : products) {
                if (product.getId() == id) {
                    product.setQuantity(quantity);
                    break;
                }
            }
            cart.setProducts(products);
            return true;
        }
        return false;
    }

    public boolean removeProductFromCart(int cartId, int id) {
        return CART_REPOSITORY_MAP.remove(id) != null;
    }


    public boolean pay(int clientId, String promoCode) {
        return true;
    }
}
