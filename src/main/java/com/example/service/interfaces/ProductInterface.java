package com.example.service.interfaces;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductInterface {
    ResponseEntity addProduct(ProductDTO productDTO);

    ResponseEntity getAllProducts();

    ResponseEntity getProduct(Long productId);

    ResponseEntity editProduct(Product product);

    ResponseEntity deleteProduct(Long productId);

    ResponseEntity findAllProductByNameAndPriceWithPagination(String productName, Double productPrice);

    ResponseEntity findAllProductWithSearch(String productName);
    ResponseEntity findAllProductWithNativeQuery(String productName);
}
