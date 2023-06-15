package com.example.controller;

import com.example.dto.CategoryDTO;
import com.example.entity.Category;
import com.example.service.interfaces.CategoryInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryInterface categoryInterface;

    public CategoryController(CategoryInterface categoryInterface) {
        this.categoryInterface = categoryInterface;
    }

    @PostMapping(value = "/addCategory")
    public ResponseEntity addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryInterface.addCategory(categoryDTO);
    }

    @GetMapping
    public ResponseEntity getCategories(){
        return categoryInterface.getCategory();
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long categoryId){
        return categoryInterface.deleteCategory(categoryId);

    }
}
