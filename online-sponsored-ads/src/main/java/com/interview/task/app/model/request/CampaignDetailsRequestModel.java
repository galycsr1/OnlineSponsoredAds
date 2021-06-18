package com.interview.task.app.model.request;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CampaignDetailsRequestModel {
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	private String category;
	private BigDecimal bid;
	public CampaignDetailsRequestModel(String name, Date startDate, String category, BigDecimal bid) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.category = category;
		this.bid = bid;
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
	@Override
	public String toString() {
		return "CampaignDetailsRequestModel [name=" + name + ", startDate=" + startDate + ", category=" + category
				+ ", bid=" + bid + "]";
	}
	
	

}
