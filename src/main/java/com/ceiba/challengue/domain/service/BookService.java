package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public List<Book> getAllBookByBibliotecId();

	public boolean deleteBook(String id);

	public Book saveBook(BookDTO book);

	public void updateBook();

}
