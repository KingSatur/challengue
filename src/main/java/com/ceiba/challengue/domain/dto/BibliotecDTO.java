package com.ceiba.challengue.domain.dto;

import java.util.List;

import com.ceiba.challengue.domain.model.Book;

public class BibliotecDTO {

	private String name;
	private Integer foundedIn;
	private List<BookDTO> books;

	public String getName() {
		return name;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFoundedIn() {
		return foundedIn;
	}

	public void setFoundedIn(Integer foundedIn) {
		this.foundedIn = foundedIn;
	}

}
