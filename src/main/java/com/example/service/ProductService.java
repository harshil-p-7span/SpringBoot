package com.example.service;

import com.example.dto.ProductDTO;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.service.interfaces.ProductInterface;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class ProductService implements ProductInterface {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<?> addProduct(ProductDTO productDTO) {
        LOGGER.info("Adding Product");
        Product product = ProductMapper.MAPPER.mapToProduct(productDTO);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        if (Objects.isNull(category))
            return new ResponseEntity<>("category require", HttpStatus.BAD_REQUEST);
        else
            product.setCategory(category);
        Product saveProduct = productRepository.save(product);
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

    @Override
    public ResponseEntity findAllProductByNameAndPriceWithPagination(String productName, Double productPrice) {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<Product> products = productRepository.findAllByProductNameAndProductPriceGreaterThan(productName, productPrice, pageRequest);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findAllProductWithSearch(String productName) {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("productPrice").descending());
        Page<Product> products = productRepository.findAllByProductNameContains(productName, pageRequest);
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findAllProductWithNativeQuery(String productName) {
        PageRequest pageRequest = PageRequest.of(0, 4, Sort.by("product_price").descending());
        List<Product> products = productRepository.findAllProducts(productName, pageRequest);
        return new ResponseEntity(products, HttpStatus.OK);
    }
}
