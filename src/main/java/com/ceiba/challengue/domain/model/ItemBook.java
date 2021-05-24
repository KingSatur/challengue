package com.ceiba.challengue.domain.model;

import java.math.BigInteger;

public class ItemBook {

	private BigInteger quantity;
	private boolean active;
	private String bookId;
	private String bibliotecId;
	private String id;

	public ItemBook(String id, BigInteger quantity,
			boolean active, String bookId,
			String bibliotecId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.active = active;
		this.bookId = bookId;
		this.bibliotecId = bibliotecId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public String getBibliotecId() {
		return bibliotecId;
	}

	public void setBibliotecId(String bibliotecId) {
		this.bibliotecId = bibliotecId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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
