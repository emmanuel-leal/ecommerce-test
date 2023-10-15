package com.emmanuel.test.products.infrastructure.configuration;

import com.emmanuel.test.products.domain.dto.ResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsConfig {
    @Bean
    public ResponseDTO productResponse() {
        return new ResponseDTO();
    }
}
