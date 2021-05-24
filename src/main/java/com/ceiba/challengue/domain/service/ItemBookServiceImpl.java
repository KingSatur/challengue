package com.ceiba.challengue.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.challengue.domain.dto.ItemBookDTO;
import com.ceiba.challengue.domain.dto.ItemBookOutDTO;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.model.ItemBook;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.repository.ItemBookRepository;

public class ItemBookServiceImpl
		implements ItemBookService {

	private final ItemBookRepository repository;
	private final BookRepository bookRepository;

	public ItemBookServiceImpl(
			ItemBookRepository repository,
			BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
		this.bookRepository = bookRepository;
	}

	@Override
	public List<ItemBookOutDTO> getItemBooksByBibliotec(
			String bibliotecId) {
		List<ItemBook> domainItemsBooks = this.repository
				.getItemBooksByBibliotec(bibliotecId);
		List<Book> books = this.bookRepository.findAll();

		List<ItemBookOutDTO> outItemsBooks = domainItemsBooks
				.stream().map(m -> {
					Book actuallyBook = books.stream()
							.filter(book -> book.getId()
									.equals(m.getBookId()))
							.findAny().orElse(null);
					return new ItemBookOutDTO(m.getId(),
							m.getBibliotecId(),
							m.getQuantity(), m.isActive(),
							actuallyBook);
				}).collect(Collectors.toList());
		return outItemsBooks;
	}

	@Override
	public List<ItemBook> addItemBooks(
			List<ItemBookDTO> dtos) {
		List<ItemBook> domainItemsBooks = this.repository
				.saveItemsBooks(dtos);
		return domainItemsBooks;
	}

	@Override
	public boolean deleteByBookId(String id) {
		return this.repository.deleteByBookId(id);
	}

}
