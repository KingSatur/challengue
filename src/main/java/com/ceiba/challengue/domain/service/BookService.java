package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.model.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public List<Book> getAllBookByBibliotecId();

	public void deleteBook();

	public void saveBook();

	public void updateBook();

}
