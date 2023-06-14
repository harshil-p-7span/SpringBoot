package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.interfaces.ProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements ProductInterface {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> addProduct(Product product) {
        LOGGER.info("Adding Product");
        Product product1 = new Product();
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        Product saveProduct = productRepository.save(product1);
        LOGGER.info("Product Added with ID : " + saveProduct.getId());
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        LOGGER.info("Fetch All Product");
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getProduct(Long productId) {
        LOGGER.info("Getting Product with ID : " + productId);
        Product product = productRepository.findById(productId).orElse(null);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> editProduct(Product product) {
        LOGGER.info("Editing Product");
        Product product1 = productRepository.findById(product.getId()).get();
        product1.setProductPrice(product.getProductPrice());
        product1.setProductName(product.getProductName());
        Product editedProduct = productRepository.save(product1);
        return new ResponseEntity<>(editedProduct, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long productId) {
        LOGGER.info("Deleting Product");
        Product product = productRepository.findById(productId).orElse(null);
        if (Objects.isNull(product))
            return new ResponseEntity<>("Product Not Found", HttpStatus.OK);
        else {
            productRepository.delete(product);
            return new ResponseEntity<>("Product delete successfully", HttpStatus.OK);
        }
    }
}
