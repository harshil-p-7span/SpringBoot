package com.example.service.interfaces;

import com.example.entity.Product;
import org.springframework.http.ResponseEntity;

public interface ProductInterface {
    ResponseEntity addProduct(Product product);

    ResponseEntity getAllProducts();

    ResponseEntity getProduct(Long productId);

    ResponseEntity editProduct(Product product);

    ResponseEntity deleteProduct(Long productId);
}
