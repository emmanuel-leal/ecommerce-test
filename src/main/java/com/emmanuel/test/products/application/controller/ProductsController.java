package com.emmanuel.test.products.application.controller;


import com.emmanuel.test.products.application.service.ProductsService;
import com.emmanuel.test.products.domain.dto.ProductsDto;
import com.emmanuel.test.products.domain.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {


    private final ProductsService productService;

    @GetMapping
    @Operation(summary = "getAll products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllProducts() {
        return productService.getAllProducts();
    }

    ;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO saveProduct(@RequestBody ProductsDto product) {
        return this.productService.saveProduct(product);
    }

    ;

    @PutMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO updateProduct(@RequestBody ProductsDto product) {
        return this.productService.updateProduct(product);
    }

    ;

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getProductById(@PathVariable String productId) {
        return this.productService.getProductById(productId);
    }

    ;

    @DeleteMapping("/product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestBody ProductsDto product) {
        this.productService.deleteProduct(product);
    }

    ;

}
