package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;

public class BookServiceImpl implements BookService {
	
	
	private final BookRepository bookRepository;

	public BookServiceImpl(final BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookByBibliotecId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook() {
		// TODO Auto-generated method stub
		
	}
	
	
}
