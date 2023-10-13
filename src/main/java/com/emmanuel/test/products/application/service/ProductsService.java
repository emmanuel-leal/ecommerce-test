package com.emmanuel.test.products.application.service;


import com.emmanuel.test.products.domain.dto.ProductsDto;
import com.emmanuel.test.products.domain.dto.ResponseDTO;

public interface ProductsService {

	ResponseDTO getAllProducts();

	ResponseDTO saveProduct(ProductsDto productRequest);

	void deleteProduct(ProductsDto productRequest);

	ResponseDTO getProductById(String productId);

	ResponseDTO updateProduct(ProductsDto productRequest);
}
