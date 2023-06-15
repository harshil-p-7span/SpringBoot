package com.example.mapper;

import com.example.dto.CategoryDTO;
import com.example.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO mapToCategoryDto(Category category);

    Category mapToCategory(CategoryDTO categoryDTO);
}
