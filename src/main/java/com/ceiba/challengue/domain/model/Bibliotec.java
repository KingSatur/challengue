package com.ceiba.challengue.domain.model;

import com.ceiba.challengue.domain.exception.BibliotecBussinesBrokenException;
import com.ceiba.challengue.domain.validators.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bibliotec {

	private String id;
	private String name;
	private Integer foundedIn;
	private List<ItemBook> books;
//	private Address address;

	public Bibliotec(final String id, final String name, final Integer foundedIn, final List<ItemBook> books) {
		Validator.validate(name, "Name can not be null");
		Validator.validate(foundedIn, "FoundedIn can not be null");
		Validator.validate(books, "books can not be null");
		this.id = id;
		this.name = name;
		this.foundedIn = foundedIn;
		this.books = books;
		// TODO Auto-generated constructor stub
	}

	public void addBook(final ItemBook book) {
		if (book == null) {
			throw new BibliotecBussinesBrokenException("Book can not be null");
		}
		this.books.add(book);
	}

	public List<ItemBook> getBooks() {
		return books;
	}

	public void setBooks(List<ItemBook> books) {
		this.books = books;
	}

	public void setFoundedIn(Integer foundedIn) {
		this.foundedIn = foundedIn;
	}

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

	public int getFoundedIn() {
		return foundedIn;
	}

	public void setFoundedIn(int foundedIn) {
		this.foundedIn = foundedIn;
	}

}
