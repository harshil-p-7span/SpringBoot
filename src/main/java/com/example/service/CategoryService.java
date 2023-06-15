package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.entity.Category;
import com.example.mapper.CategoryMapper;
import com.example.repository.CategoryRepository;
import com.example.service.interfaces.CategoryInterface;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService implements CategoryInterface {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public ResponseEntity addCategory(CategoryDTO categoryDTO) {
        CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);
        Category category = mapper.mapToCategory(categoryDTO);
        Category saveCategory = categoryRepository.save(category);
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
        CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);
        categories.stream().map(category -> {
            return mapper.mapToCategoryDto(category);
        });
        return new ResponseEntity(categories, HttpStatus.OK);

    }
}
