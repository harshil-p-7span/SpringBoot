package com.example.mapper;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDTO mapToProductDto(Product product);

    Product mapToProduct(ProductDTO productDTO);
}
