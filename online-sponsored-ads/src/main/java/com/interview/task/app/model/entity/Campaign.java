package com.interview.task.app.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="campaign")
public class Campaign {
	@Id
	private UUID id;
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	private String category;
	private BigDecimal bid;
	
	@ManyToMany(targetEntity = Product.class , fetch = FetchType.EAGER)
	private List<Product> products;
	
	public Campaign() {
		super();
	}

	public Campaign(UUID id, String name, Date startDate, String category, BigDecimal bid,
			List<com.interview.task.app.model.entity.Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.category = category;
		this.bid = bid;
		this.products = products;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", startDate=" + startDate + ", category=" + category
				+ ", bid=" + bid + ", products=" + products + "]";
	}
	
	
	

}
