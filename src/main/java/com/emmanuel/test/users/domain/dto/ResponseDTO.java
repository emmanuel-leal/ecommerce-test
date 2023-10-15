package com.emmanuel.test.users.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {

	private String message;
	private String statusCode;
	private Object data;
}
