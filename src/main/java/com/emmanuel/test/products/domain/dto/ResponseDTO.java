package com.emmanuel.test.products.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private String message;
    private String statusCode;
    private Object data;
}
