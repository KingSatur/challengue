package com.ceiba.challengue.domain.dto;

import java.math.BigInteger;

import com.ceiba.challengue.domain.model.Book;

public class ItemBookOutDTO {

	private String id;
	private String bibliotecId;
	private BigInteger quantity;
	private boolean active;
	private Book book;

	public ItemBookOutDTO(String id, String bibliotecId,
			BigInteger quantity, boolean active,
			Book book) {
		super();
		this.id = id;
		this.bibliotecId = bibliotecId;
		this.quantity = quantity;
		this.active = active;
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBibliotecId() {
		return bibliotecId;
	}

	public void setBibliotecId(String bibliotecId) {
		this.bibliotecId = bibliotecId;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

}
