package com.emmanuel.test.users.infrastructure.configuration;

import com.emmanuel.test.users.domain.dto.ResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {
    @Bean
    public ResponseDTO usersResponse() {
        return new ResponseDTO();
    }
}
