package com.ceiba.challengue.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceiba.challengue.domain.model.Book;

public interface BookRepository {

	public Optional<Book> findById(UUID id);

	public Optional<List<Book>> findByBibliotec(UUID bibliotescId);

	public Book saveBook(Book book, UUID bibliotecId);

}
