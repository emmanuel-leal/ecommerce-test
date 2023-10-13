package com.emmanuel.test.products.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidaDataException extends RuntimeException {

	private static final long serialVersionUID = -4173399516261184826L;

	public InvalidaDataException(String message){
		super(message);
	}


}
