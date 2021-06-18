package com.interview.task.app.repository;

import java.util.List;
import java.util.UUID;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.task.app.model.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
	List<Product> findByCategory(String category);

}
