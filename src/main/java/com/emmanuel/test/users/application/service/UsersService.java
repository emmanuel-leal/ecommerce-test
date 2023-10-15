package com.emmanuel.test.users.application.service;

import com.emmanuel.test.users.domain.dto.ResponseDTO;
import com.emmanuel.test.users.domain.dto.UsersDto;

public interface UsersService {

	ResponseDTO getAllUSers();

	ResponseDTO saveUser(UsersDto userRequest);
	
	ResponseDTO updateUser(UsersDto userRequest);

	ResponseDTO deleteUser(UsersDto userRequest);

	ResponseDTO getUserById(String userIdRequest);
}
