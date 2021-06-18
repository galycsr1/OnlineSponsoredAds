package com.interview.task.app.model.request;

public class ServeAdDetailsRequestModel {
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
