package com.ceiba.challengue.domain.service;

import java.util.List;
import java.util.UUID;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;

public class BussinesServiceImpl implements BibliotecBussinesService {

	private final BibliotecRepository bibliotecRepository;
	private final BookRepository bookRepository;

	public BussinesServiceImpl(final BibliotecRepository bibliotecRepository, final BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecRepository = bibliotecRepository;
		this.bookRepository = bookRepository;
	}

	
	
	@Override
	public void createBibliotec(Bibliotec bibliotec) {
		// TODO Auto-generated method stub
		System.out.println("Here");
		this.bibliotecRepository.save(bibliotec);

	}

	@Override
	public void createBook(Book book, UUID bibliotecId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Book> getAllBookByBibliotec(UUID bibliotecId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Bibliotec> getAllBibliotec() {
		// TODO Auto-generated method stub
		return this.bibliotecRepository.findAll();
	}

}
