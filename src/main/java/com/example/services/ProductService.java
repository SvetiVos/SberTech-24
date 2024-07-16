package com.example.services;


import com.example.models.Product;
import com.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public long createProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public boolean deleteProduct(int id) {
        productRepository.deleteById(id);
        return true;
    }

    public Optional<Product> search(int id) {
        return productRepository.findById(id);
    }

}
