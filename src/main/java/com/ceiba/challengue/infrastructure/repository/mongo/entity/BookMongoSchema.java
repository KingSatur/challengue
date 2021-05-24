package com.ceiba.challengue.infrastructure.repository.mongo.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class BookMongoSchema {

	@Id
	private String id;
	private String name;
	private BigDecimal price;
	private Boolean active;
	private Date enteredOn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getEnteredOn() {
		return enteredOn;
	}
	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}
	public BookMongoSchema(String name, BigDecimal price, Boolean active, Date enteredOn) {
		super();
		this.name = name;
		this.price = price;
		this.active = active;
		this.enteredOn = enteredOn;
	}
	
	
	
}
