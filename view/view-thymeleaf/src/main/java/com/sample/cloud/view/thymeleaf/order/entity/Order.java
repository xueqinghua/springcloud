package com.sample.cloud.view.thymeleaf.order.entity;

import java.util.Date;

public class Order {
	
	private String id;

	private Long amount;

	private String source;

	private Date createDate;

	public Long getAmount() {
		return amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getId() {
		return id;
	}

	public String getSource() {
		return source;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setSource(String source) {
		this.source = source;
	}

}
