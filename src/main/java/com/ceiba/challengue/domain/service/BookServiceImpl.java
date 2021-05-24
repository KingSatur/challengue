package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BookRepository;

public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(
			final BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = this.bookRepository.findAll();
		return books;
	}

	@Override
	public List<Book> getAllBookByBibliotecId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBook(String id) {
		// TODO Auto-generated method stub
		return this.bookRepository.deleteBook(id);

	}

	@Override
	public void updateBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public Book saveBook(BookDTO book) {
		// TODO Auto-generated method stub
		Book domainBook = this.bookRepository
				.saveBook(book);
		return domainBook;
	}

}
