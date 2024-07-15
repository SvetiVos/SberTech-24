package com.example.services;


import com.example.models.Product;
import com.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public long createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }

    public Optional<Product> search(int id) {
        return productRepository.search(id);
    }

}
