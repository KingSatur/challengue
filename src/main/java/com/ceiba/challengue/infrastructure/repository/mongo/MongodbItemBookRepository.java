package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ceiba.challengue.domain.dto.ItemBookDTO;
import com.ceiba.challengue.domain.model.ItemBook;
import com.ceiba.challengue.domain.repository.ItemBookRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.ItemBookMongoSchema;

@Component
@Primary
public class MongodbItemBookRepository
		implements ItemBookRepository {

	private final SpringDataMongodbItemBookRepository repository;

	@Autowired
	public MongodbItemBookRepository(
			final SpringDataMongodbItemBookRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	@Override
	public List<ItemBook> saveItemsBooks(
			List<ItemBookDTO> itemBook) {

		List<ItemBookMongoSchema> schemaBookList = itemBook
				.stream().map(m -> {
					ItemBookMongoSchema schema = new ItemBookMongoSchema(
							m.getBibliotecId(),
							m.getBookId(), m.getQuantity(),
							m.isActive());
					if (m.getId() != null) {
						schema.setId(m.getId());
					}

					return schema;
				}).collect(Collectors.toList());
		schemaBookList = this.repository
				.saveAll(schemaBookList);
		List<ItemBook> mapToDomainItemBook = schemaBookList
				.stream().map(m -> {
					return new ItemBook(m.getId(),
							m.getQuantity(), m.isActive(),
							m.getBook(), m.getBibliotec());
				}).collect(Collectors.toList());

		return mapToDomainItemBook;
	}

	@Override
	public List<ItemBook> getItemBooksByBibliotec(
			String bibliotecId) {
		List<ItemBookMongoSchema> items = this.repository
				.findByBibliotec(bibliotecId);
		List<ItemBook> domainItemBooks = items.stream()
				.map(m -> {
					return new ItemBook(m.getId(),
							m.getQuantity(), m.isActive(),
							m.getBook(), m.getBibliotec());
				}).collect(Collectors.toList());
		return domainItemBooks;
	}

	@Override
	public boolean deleteByBookId(String bookId) {
		List<ItemBookMongoSchema> domainItemsBooks = this.repository
				.deleteByBook(bookId);
		List<Boolean> completedTaskList = domainItemsBooks
				.stream()
				.map(m -> this.repository
						.existsById(m.getId()))
				.collect(Collectors.toList());
		System.out.println(completedTaskList);
		return completedTaskList.stream().allMatch(m -> !m);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
	}

}
