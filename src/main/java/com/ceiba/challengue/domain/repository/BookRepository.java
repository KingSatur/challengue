package com.ceiba.challengue.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;

public interface BookRepository {

	public Optional<Book> findById(UUID id);

	public Optional<List<Book>> findByBibliotec(
			UUID bibliotescId);

	public Book saveBook(BookDTO book);

	public List<Book> findAll();

	public List<Book> saveAllBooks(List<BookDTO> booksDto);

	public boolean deleteBook(String id);

}
