package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ProductModel;
import com.example.repo.ProductRepository;

@RestController
public class Controller {
	
	
	@Autowired
	ProductRepository ProductRepo;
	
	//save a new product
	@PostMapping("/saveProduct")
	public void saveProduct(@RequestBody ProductModel product) {
		ProductRepo.save(product);
	}
	
	//get all the products
	@GetMapping("/getAllProduct")
	public List<ProductModel> getAllProducts(){
		return (List<ProductModel>) ProductRepo.findAll();
	}
	
	//get a single products
	@PostMapping("/getProduct")
	public Optional<ProductModel> getProduct(@RequestBody LinkedHashMap<String,Object> data) {
		return ProductRepo.findById(data.get("productId").toString());
	}
	
	//get a single products
	@PostMapping("/deleteProduct")
	public void deleteProduct(@RequestBody LinkedHashMap<String,Object> data) {
		ProductRepo.deleteById(data.get("productId").toString());
	}
	
	//get by Type
	@PostMapping("/getByType")
	public List<ProductModel> getByType(@RequestBody LinkedHashMap<String,Object> data){
		return ProductRepo.findAllByType(data.get("type").toString());
	}
}
