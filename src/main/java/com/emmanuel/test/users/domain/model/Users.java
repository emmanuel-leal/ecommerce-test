package com.emmanuel.test.users.domain.model;

import com.emmanuel.test.users.domain.dto.RolEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Users {

	@Id
	@GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id")
	private String userId;
	
	private String name;
	
	private String lastName;
	
	private String secondLastName;

	private RolEnum role;
	
	private boolean isVerified;
	
	private String password;
	
	private String email;
	
}