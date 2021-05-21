package com.ceiba.challengue.domain.model;

import com.ceiba.challengue.domain.exception.BibliotecBussinesBrokenException;
import com.ceiba.challengue.domain.validators.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bibliotec {

	private UUID id;
	private String name;
	private Integer foundedIn;
	private List<Book> books;
//	private Address address;

	public Bibliotec(final UUID id, final String name, final Integer foundedIn) {
		Validator.validate(name, "Name can not be null");
		Validator.validate(foundedIn, "FoundedIn can not be null");
		this.id = id;
		this.name = name;
		this.foundedIn = foundedIn;
		this.books = new ArrayList<Book>();
		// TODO Auto-generated constructor stub
	}

	public void addBook(final Book book) {
		if (book == null) {
			throw new BibliotecBussinesBrokenException("Book can not be null");
		}
		this.books.add(book);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
