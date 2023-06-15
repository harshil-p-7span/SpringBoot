package com.example.service.interfaces;

import com.example.dto.CategoryDTO;
import com.example.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryInterface {
    ResponseEntity addCategory(CategoryDTO categoryDTO);
    ResponseEntity deleteCategory(Long categoryId);
    ResponseEntity getCategory();
}
