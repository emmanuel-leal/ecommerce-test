package com.emmanuel.test.users.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration @EnableSwagger2
public class UsersSwaggerConfig {

    @Bean
    public Docket apiUsers() {
        return new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emmanuel.test.users.application.controller"))
                .build()
                .groupName("USERS")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API de Ejemplo")
                .description("Documentación de la API de ejemplo con Swagger")
                .version("1.0")
                .build();
    }
}