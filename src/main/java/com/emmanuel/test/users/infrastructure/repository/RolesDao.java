package com.emmanuel.test.users.infrastructure.repository;

import com.emmanuel.test.users.domain.model.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesDao extends CrudRepository<Roles, String>{

}
