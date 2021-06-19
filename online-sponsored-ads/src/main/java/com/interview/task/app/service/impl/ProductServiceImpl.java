package com.interview.task.app.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.task.app.exception.CreationFailedException;
import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.ProductDetailsRequestModel;
import com.interview.task.app.repository.ProductRepository;
import com.interview.task.app.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	
	@Transactional
    public Product addProduct(ProductDetailsRequestModel productDetails)  {
		Product product = new Product(UUID.randomUUID(), productDetails.getTitle(), productDetails.getCategory(), productDetails.getPrice());
		productRepository.save(product);
		if(!productRepository.existsById(product.getProductSerialNumber())) {
			throw new CreationFailedException("Product Creation Failed"); 			
     	}
		return productRepository.findById(product.getProductSerialNumber()).get();
		
	}
	
	@Transactional
    public List<Product> getProductByCategory(String category)  {
		return productRepository.findByCategory(category);
		
	}

}
