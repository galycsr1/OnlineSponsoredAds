package com.interview.task.app.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.ProductDetailsRequestModel;
import com.interview.task.app.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	
	@Transactional
    public ResponseEntity<Object> addProduct(ProductDetailsRequestModel productDetails)  {
		Product product = new Product(UUID.randomUUID(), productDetails.getTitle(), productDetails.getCategory(), productDetails.getPrice());
		productRepository.save(product);
		if(!productRepository.existsById(product.getProductSerialNumber())) {
			return ResponseEntity.unprocessableEntity().body("Product Creation Failed");
	
    	}else{
     		return ResponseEntity.unprocessableEntity().body("Product Creation Succsess");
     	}
		
	}
	
	@Transactional
    public List<Product> getProductByCategory(String category)  {
		return productRepository.findByCategory(category);
		
	}

}
