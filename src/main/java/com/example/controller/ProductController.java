package com.example.controller;

import com.example.models.Client;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> read() {
        final List<Product> products = productService.readAll();

        return ResponseEntity.of(Optional.ofNullable(products));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> read(@PathVariable(name = "id") int id) {
        final Optional<Product> product = Optional.ofNullable(productService.read(id));
        return ResponseEntity.of(product);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
        final boolean deleted = productService.deleteProduct(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/products/{id}")
    public ResponseEntity<?> changeProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
        final boolean updated = productService.changeProduct(product, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}