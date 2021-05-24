package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.model.ItemBook;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.repository.ItemBookRepository;

public class BibliotecServiceImpl
		implements BibliotecService {

	private final BibliotecRepository bibliotecRepository;
	private final BookRepository bookRepository;
	private final ItemBookRepository itemBookRepository;

	public BibliotecServiceImpl(
			final BibliotecRepository bibliotecRepository,
			final BookRepository bookRepository,
			final ItemBookRepository itemBookRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecRepository = bibliotecRepository;
		this.itemBookRepository = itemBookRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public Bibliotec saveBibliotec(BibliotecDTO bibliotec) {

		Bibliotec domainBibliotec = this.bibliotecRepository
				.save(bibliotec);
		if (bibliotec.getBooks() != null
				&& bibliotec.getBooks().size() > 0) {
			this.itemBookRepository
					.saveItemsBooks(bibliotec.getBooks());
		}
		if (bibliotec.getId() != null) {
			List<ItemBook> domainItemsBookFromBibliotec = this.itemBookRepository
					.getItemBooksByBibliotec(
							bibliotec.getId());
			domainItemsBookFromBibliotec.forEach(
					domainItemBook -> domainBibliotec
							.addBook(domainItemBook));

		}
		return domainBibliotec;
	}

	@Override
	public List<Bibliotec> getAllBibliotec() {
		List<Bibliotec> domainBibliotecs = this.bibliotecRepository
				.findAll();

		return domainBibliotecs;
	}

	@Override
	public Bibliotec getBibliotecById(String id) {
		return null;

	}

	@Override
	public List<Book> addBooks(List<Book> books,
			String bibliotecId) {
		return books;
	}

	@Override
	public Bibliotec editBibliotec(
			BibliotecDTO bibliotecDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
