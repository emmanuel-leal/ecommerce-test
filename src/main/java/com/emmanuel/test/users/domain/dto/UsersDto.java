package com.emmanuel.test.users.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
	
	@JsonInclude(Include.NON_EMPTY)
	private String loggedUserId;
	private String userId;
	private String name;
	private String lastName;
	private String secondLastName;
	private RolEnum role;
	private boolean verified;
	private String email;
	private String password;
}
