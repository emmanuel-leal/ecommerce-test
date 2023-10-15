package com.emmanuel.test.users.infrastructure.repository;


import com.emmanuel.test.users.domain.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRespository extends CrudRepository<Users, String> {

	List<Users> findAll();

}
