package com.ceiba.challengue.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.exception.BibliotecBussinesBrokenException;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.repository.ItemBookRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BibliotecMongoSchema;

public class BibliotecServiceImpl implements BibliotecService {

	private final BibliotecRepository bibliotecRepository;
	private final BookRepository bookRepository;
	private final ItemBookRepository itemBookRepository;

	public BibliotecServiceImpl(final BibliotecRepository bibliotecRepository, 
			final BookRepository bookRepository,
			final ItemBookRepository itemBookRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecRepository = bibliotecRepository;
		this.itemBookRepository = itemBookRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public Bibliotec createBibliotec(BibliotecDTO bibliotec) {
		if (bibliotec.getBooks() != null && bibliotec.getBooks().size() > 0) {
			return null;
		} else {
			return this.bibliotecRepository.create(bibliotec);
		}
	}

	@Override
	public List<Bibliotec> getAllBibliotec() {
		// TODO Auto-generated method stub
		return this.bibliotecRepository.findAll();
	}

	@Override
	public Bibliotec getBibliotecById(String id) {
		return null;

	}

	@Override
	public List<Book> addBooks(List<Book> books, String bibliotecId) {
		return books;
	}

	@Override
	public Bibliotec editBibliotec(BibliotecDTO bibliotecDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
