package com.ceiba.challengue.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ceiba.challengue.domain.validators.Validator;

public class Book {

	private String name;
	private BigDecimal price;
	private Boolean active;
	private Date enteredOn;

	public Book(String name, BigDecimal price, boolean active, Date enteredOn) {
		Validator.validate(name, "Name can not be null");
		Validator.validate(price, "Price can not be null");
		Validator.validate(active, "active can not be null");
		Validator.validate(enteredOn, "enteredOn can not be null");
		this.name = name;
		this.price = price;
		this.active = active;
		this.enteredOn = enteredOn;
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
	
	

}
