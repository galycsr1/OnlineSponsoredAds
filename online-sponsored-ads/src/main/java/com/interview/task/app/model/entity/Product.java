package com.interview.task.app.model.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product {
	
	@Id	
	private UUID productSerialNumber;
	private String title;
	private String category;
	private BigDecimal price;
	
	public Product() {
		super();
	}
	public Product(UUID productSerialNumber, String title, String category, BigDecimal price) {
		super();
		this.productSerialNumber = productSerialNumber;
		this.title = title;
		this.category = category;
		this.price = price;
	}
	public UUID getProductSerialNumber() {
		return productSerialNumber;
	}
	public void setProductSerialNumber(UUID productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
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
		return "Product [productSerialNumber=" + productSerialNumber + ", title=" + title + ", category=" + category
				+ ", price=" + price + "]";
	}
	
	
}
