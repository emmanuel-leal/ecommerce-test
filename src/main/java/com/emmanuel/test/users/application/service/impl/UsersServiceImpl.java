package com.emmanuel.test.users.application.service.impl;

import com.emmanuel.test.products.domain.exception.InternalErrorException;
import com.emmanuel.test.products.domain.exception.InvalidaDataException;
import com.emmanuel.test.users.application.service.UsersService;
import com.emmanuel.test.users.domain.converter.UsersConverter;
import com.emmanuel.test.users.domain.dto.ResponseDTO;
import com.emmanuel.test.users.domain.dto.RolEnum;
import com.emmanuel.test.users.domain.dto.UsersDto;
import com.emmanuel.test.users.domain.model.Users;
import com.emmanuel.test.users.infrastructure.repository.UsersRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

	private final UsersRespository usersRepository;

	private final ResponseDTO usersResponse;

	@Override
	public ResponseDTO getAllUSers() {
		try {
			var users = this.usersRepository.findAll();
			return this.validateSizeUserList(users);
		} catch (Exception e) {
			log.error("Error to get data {}",e.getMessage());
			throw new InternalErrorException("Error to get all users");
		}
	}

	private ResponseDTO validateSizeUserList(List<Users> usersList) {
		if (usersList.isEmpty()) {
			return this.createResponse(null, HttpStatus.NO_CONTENT.toString(), "user list not founded");
		} else {
			List<UsersDto> usersListDto = usersList.stream().map(UsersConverter.INSTANCE::toUsersDto).collect(Collectors.toList());
			return this.createResponse(usersListDto, HttpStatus.OK.toString(), "user list founded");
		}
	}

	@Override
	public ResponseDTO getUserById(String userIdRequest) {
		try {
			var user = this.usersRepository.findById(userIdRequest);
			if (user.isPresent()) {
				var userResponse = UsersConverter.INSTANCE.toUsersDto(user.get());
				return this.createResponse(userResponse, "200", "success to get user");
			} else {
				throw new InvalidaDataException("User not founded verify data");
			}

		} catch (Exception e) {
			log.error("Error to get user id: {} message {}", userIdRequest, e.getMessage());
			throw new InvalidaDataException("User not founded verify data");
		}
	}

	@Override
	public ResponseDTO saveUser(UsersDto userRequest) {
		try {
			Users userTosave = UsersConverter.INSTANCE.toUsersModel(userRequest);
			var user = this.usersRepository.findById(userRequest.getLoggedUserId());
			var userResponse = this.usersRepository.save(userTosave);
			log.info("user saved {}", userResponse);
			return this.createResponse(userResponse, HttpStatus.CREATED.toString(), "Success user saved");
		} catch (Exception e) {
			log.error("Error to save user {}", e.getMessage().toString());
			throw new InternalErrorException("Error tu save user");
		}
	}

	@Override
	public ResponseDTO updateUser(UsersDto userRequest) {
		try {
			UsersDto userDto = (UsersDto) this.getUserById(userRequest.getLoggedUserId()).getData();
			UsersConverter.INSTANCE.updateProductDTO(userRequest,userDto);
				var userResponse = this.saveUser(userDto);
				log.info("user updated {}", userResponse);
				return this.createResponse(userResponse, HttpStatus.OK.toString(), "Success user updated");

		} catch (Exception e) {
			log.error("Error to update user {}",userRequest);
			throw new InternalErrorException("Error to update user");
		}
	}

	@Override
	public ResponseDTO deleteUser(String userId) {
		try {
			var user = (UsersDto)this.getUserById(userId).getData();
			if (user != null && isAdminRole(user.getRole())) {
				this.usersRepository.delete(UsersConverter.INSTANCE.toUsersModel(user));
				return this.createResponse(null, HttpStatus.NO_CONTENT.toString(), "Success user deleted");
			} else {
				log.error("Error to delete user with id {}", userId);
				throw new InvalidaDataException("Error to delete user");
			}
		} catch (Exception e) {
			log.error("Error to delete user id {}",e.getMessage());
			throw new InvalidaDataException("Error to delete user");
		}
	}

	private ResponseDTO createResponse(Object data, String statusCode, String message) {
		this.usersResponse.setData(data);
		this.usersResponse.setMessage(message);
		this.usersResponse.setStatusCode(statusCode);
		return this.usersResponse;
	}

	private boolean isAdminRole(RolEnum role) {
		return RolEnum.ADMIN == role;
	}

}
