package com.ceiba.challengue.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;

public class BibliotecServiceImpl implements BibliotecService {

	private final BibliotecRepository bibliotecRepository;
	private final BookRepository bookRepository;

	public BibliotecServiceImpl(final BibliotecRepository bibliotecRepository, final BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecRepository = bibliotecRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public Bibliotec createBibliotec(BibliotecDTO bibliotec) {
		// TODO Auto-generated method stub

		List<Book> books = bibliotec.getBooks() != null ? this.bookRepository.saveAllBooks(bibliotec.getBooks())
				: new ArrayList<>();
		bibliotec.setBooks(books.stream().map(m -> {
			BookDTO n = new BookDTO();
			n.setId(m.getId());
			n.setPrice(m.getPrice());
			n.setActive(m.getActive());
			n.setEnteredOn(m.getEnteredOn());
			n.setName(m.getName());
			return n;
		}).collect(Collectors.toList()));

		Bibliotec c = this.bibliotecRepository.save(bibliotec);
		return c;

	}

	@Override
	public List<Bibliotec> getAllBibliotec() {
		// TODO Auto-generated method stub
		return this.bibliotecRepository.findAll();
	}

}
