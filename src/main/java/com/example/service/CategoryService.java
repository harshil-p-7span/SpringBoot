package com.example.service;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.interfaces.CategoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService implements CategoryInterface {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity addCategory(Category category) {
        Category category1 = new Category();
        category1.setCategoryName(category.getCategoryName());
        Category saveCategory = categoryRepository.save(category1);
        return new ResponseEntity(saveCategory, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (Objects.isNull(category))
            return new ResponseEntity("Category Not Found", HttpStatus.OK);
        else {
            categoryRepository.delete(category);
            return new ResponseEntity("Category delete successfully", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity getCategory() {
        List<Category> categories = categoryRepository.findAll();
        return new ResponseEntity(categories, HttpStatus.OK);

    }
}
