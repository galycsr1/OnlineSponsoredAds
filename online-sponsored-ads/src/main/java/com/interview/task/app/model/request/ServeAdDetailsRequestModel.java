package com.interview.task.app.model.request;

import javax.validation.constraints.NotEmpty;

public class ServeAdDetailsRequestModel {
	@NotEmpty(message = "category is mandatory")
	private String category;
	
	public ServeAdDetailsRequestModel() {
		super();
		
	}
	public ServeAdDetailsRequestModel(String category) {
		super();
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

}
