package com.ceiba.challengue.infrastructure.repository.mongo.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itemsbooks")
public class ItemBookMongoSchema {

	@Id
	private String id;
	private String bibliotec;
	private String book;
	private BigInteger quantity;
	private boolean active;

	public ItemBookMongoSchema(String bibliotec,
			String book, BigInteger quantity,
			boolean active) {
		super();
		this.bibliotec = bibliotec;
		this.book = book;
		this.quantity = quantity;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBibliotec() {
		return bibliotec;
	}

	public void setBibliotec(String bibliotec) {
		this.bibliotec = bibliotec;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
