package com.example.controller;

import com.example.entity.Product;
import com.example.service.interfaces.ProductInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductInterface productInterface;

    public ProductController(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity addProduct(@RequestBody Product product) {
        return productInterface.addProduct(product);
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return productInterface.getAllProducts();
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity getProduct(@PathVariable Long productId) {
        return productInterface.getProduct(productId);
    }

    @PutMapping(value = "/editProduct")
    public ResponseEntity editProduct(@RequestBody Product product) {
        return productInterface.editProduct(product);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        return productInterface.deleteProduct(productId);
    }
}
