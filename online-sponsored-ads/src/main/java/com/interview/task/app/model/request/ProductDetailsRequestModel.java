package com.interview.task.app.model.request;

import java.math.BigDecimal;

public class ProductDetailsRequestModel {
	private String title;
	private String category;
	private BigDecimal price;
	public ProductDetailsRequestModel(String title, String category, BigDecimal price) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDetailsRequestModel [title=" + title + ", category=" + category + ", price=" + price + "]";
	}
	
}
