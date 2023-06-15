package com.example.service.interfaces;

import com.example.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryInterface {
    ResponseEntity addCategory(Category category);
    ResponseEntity deleteCategory(Long categoryId);
    ResponseEntity getCategory();
}