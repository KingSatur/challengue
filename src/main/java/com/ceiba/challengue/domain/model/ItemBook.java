package com.ceiba.challengue.domain.model;

import java.math.BigInteger;

public class ItemBook {

	private BigInteger quantity;
	private boolean active;
	private Book book;

	public ItemBook(BigInteger quantity, boolean active, Book book) {
		super();
		this.quantity = quantity;
		this.active = active;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
