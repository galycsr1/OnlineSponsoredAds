package com.interview.task.app.service;

import java.util.List;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.ProductDetailsRequestModel;



public interface ProductService{
	
	public Product addProduct(ProductDetailsRequestModel productDetails);
	public List<Product> getProductByCategory(String category);
		

}
