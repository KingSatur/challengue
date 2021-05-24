package com.ceiba.challengue.domain.dto;

import java.math.BigInteger;

public class ItemBookDTO {

	private String id;
	private String bookId;
	private String bibliotecId;
	private BigInteger quantity;
	private boolean active;

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

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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
