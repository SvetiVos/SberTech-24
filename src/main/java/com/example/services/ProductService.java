package com.example.services;


import com.example.models.Product;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {

    private static final Map<Integer, Product> PRODUCT_REPOSITORY_MAP = new HashMap<>();

    private static final Integer PRODUCT_ID_HOLDER = 0;

    public List<Product> readAll() {
        return new ArrayList<>(PRODUCT_REPOSITORY_MAP.values());
    }

    public Product read(int id) {
        return PRODUCT_REPOSITORY_MAP.get(id);
    }

    public void createProduct(Product product) {
        final int productId = PRODUCT_ID_HOLDER + 1;
        product.setId(productId);
        PRODUCT_REPOSITORY_MAP.put(productId, product);
    }

    public boolean deleteProduct(int id) {
        return PRODUCT_REPOSITORY_MAP.remove(id) != null;
    }

    public boolean changeProduct(Product product, int id) {
        if (PRODUCT_REPOSITORY_MAP.containsKey(id)) {
            product.setId(id);
            PRODUCT_REPOSITORY_MAP.put(id, product);
            return true;
        }

        return false;
    }

}
