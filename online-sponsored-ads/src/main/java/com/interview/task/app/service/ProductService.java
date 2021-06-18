package com.interview.task.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.ProductDetailsRequestModel;



public interface ProductService{
	
	public ResponseEntity<Object> addProduct(ProductDetailsRequestModel productDetails);
	public List<Product> getProductByCategory(String category);
		

}
