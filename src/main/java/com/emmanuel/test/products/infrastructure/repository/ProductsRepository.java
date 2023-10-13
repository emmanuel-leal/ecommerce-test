package com.emmanuel.test.products.infrastructure.repository;


import com.emmanuel.test.products.domain.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Products, String> {

	List<Products> findAll();
}
