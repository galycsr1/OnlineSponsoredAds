package com.interview.task.app.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ProductDetailsRequestModel;
import com.interview.task.app.service.CampaignService;
import com.interview.task.app.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody ProductDetailsRequestModel productDetails) {
		return productService.addProduct(productDetails);
	}
}
