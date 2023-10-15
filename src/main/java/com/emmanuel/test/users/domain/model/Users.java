package com.emmanuel.test.users.domain.model;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	private Roles role;
	
	private boolean isVerified;
	
	private String password;
	
	private String email;
	
}