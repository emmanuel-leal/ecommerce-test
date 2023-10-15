package com.emmanuel.test.users.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {

	private static final long serialVersionUID = -4173399516261184826L;

	public InternalErrorException(String message){
		super(message);
	}


}
