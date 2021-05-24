package com.ceiba.challengue.domain.dto;

import java.util.List;

public class BibliotecDTO {

	private String id;
	private String name;
	private Integer foundedIn;
	private List<ItemBookDTO> books;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public List<ItemBookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<ItemBookDTO> books) {
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
