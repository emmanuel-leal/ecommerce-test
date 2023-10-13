package com.emmanuel.test.products.domain.converter;

import com.emmanuel.test.products.domain.dto.ProductsDto;
import com.emmanuel.test.products.domain.model.Products;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsConverter {
    ProductsConverter INSTANCE = Mappers.getMapper(ProductsConverter.class);

//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "productId", ignore = true)
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    Products toProductsModel(ProductsDto productsDto);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    ProductsDto toProductsDto(Products products);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateModel(ProductsDto productsDto, @MappingTarget Products products);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateDTO(Products products, @MappingTarget ProductsDto productsDto);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateProductDTO(ProductsDto productsDto, @MappingTarget ProductsDto products);
}
