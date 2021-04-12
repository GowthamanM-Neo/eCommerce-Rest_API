package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, String>{

	List<ProductModel> findAllByType(String string);
		
}
