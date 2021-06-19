package com.interview.task.app.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.ProductDetailsRequestModel;
import com.interview.task.app.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Product save(@Valid @RequestBody ProductDetailsRequestModel productDetails) {
		return productService.addProduct(productDetails);
	}
}
