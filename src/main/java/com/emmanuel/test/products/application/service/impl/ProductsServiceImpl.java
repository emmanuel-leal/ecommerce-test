package com.emmanuel.test.products.application.service.impl;

import com.emmanuel.test.products.application.service.ProductsService;
import com.emmanuel.test.products.domain.converter.ProductsConverter;
import com.emmanuel.test.products.domain.dto.ProductsDto;
import com.emmanuel.test.products.domain.dto.ResponseDTO;
import com.emmanuel.test.products.domain.exception.InternalErrorException;
import com.emmanuel.test.products.domain.exception.InvalidaDataException;
import com.emmanuel.test.products.domain.model.Products;
import com.emmanuel.test.products.infrastructure.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {


    private final ProductsRepository productsRepository;


    private final ResponseDTO productResponse;

    @Override
    public ResponseDTO getAllProducts() {
        try {
            var products = this.productsRepository.findAll();
            return this.validateSizeProductsList(products);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalErrorException(e.getMessage());
        }
    }

    private ResponseDTO validateSizeProductsList(List<Products> productList) {
        if (productList.isEmpty()) {
            return this.createResponse(null, HttpStatus.NO_CONTENT.toString(), "product list not founded");
        } else {
            List<ProductsDto> productListDto = productList.stream().map(ProductsConverter.INSTANCE::toProductsDto).collect(Collectors.toList());
            return this.createResponse(productListDto, HttpStatus.OK.toString(), "product list founded");
        }
    }

    @Override
    public ResponseDTO getProductById(String productId) {
        if (!StringUtils.isEmpty(productId)) {
            var product = this.productsRepository.findById(productId);
            if (product.isPresent()) {
                return this.createResponse(ProductsConverter.INSTANCE.toProductsDto(product.get()), HttpStatus.OK.toString(), "success to get product");
            } else {
                return this.createResponse(null, HttpStatus.NO_CONTENT.toString(), "success to get product");
            }
        } else {
            throw new InvalidaDataException("Invalid data");
        }
    }

    @Override
    public ResponseDTO saveProduct(ProductsDto productRequest) {
        try {
            Products productModel = ProductsConverter.INSTANCE.toProductsModel(productRequest);

            productModel.setUpdatedAt(Instant.now());
            productModel.setCreatedAt(Instant.now());
            var product = this.productsRepository.save(productModel);

            log.info("product saved {}", product);
            return this.createResponse(ProductsConverter.INSTANCE.toProductsDto(product), HttpStatus.CREATED.toString(), "Success product saved");

        } catch (Exception e) {
            log.error("Error to save product, message: {}", e.getMessage());
            throw new InternalErrorException("Error to save product, please retry");
        }
    }

    @Override
    public ResponseDTO updateProduct(ProductsDto productRequest) {
        var product = (ProductsDto)this.getProductById(productRequest.getProductId()).getData();
        ProductsConverter.INSTANCE.updateProductDTO(productRequest,  product);
        return this.saveProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        try {
            this.productsRepository.deleteById(productId);
        }catch (Exception ex){
            log.error("Error to delete product with id {}", productId);
            throw new InternalErrorException("Error to delete product with id {}");
        }
    }

    private ResponseDTO createResponse(Object data, String statusCode, String message) {
        this.productResponse.setData(data);
        this.productResponse.setMessage(message);
        this.productResponse.setStatusCode(statusCode);
        return this.productResponse;
    }

}
