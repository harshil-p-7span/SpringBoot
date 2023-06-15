package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductNameAndProductPriceGreaterThan(String name, Double productPrice, Pageable pageable);

    Page<Product> findAllByProductNameContains(String productName, Pageable pageable);

    @Query(value = "select * from tbl_product p where p.product_name =:productName", nativeQuery = true)
    List<Product> findAllProducts(@Param("productName") String productName, Pageable pageable);
}
