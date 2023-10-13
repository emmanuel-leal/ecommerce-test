package com.emmanuel.test.users.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Roles {

	@Id
	@Column(name = "role_id")
	private String roleId;
	private String role;
}
