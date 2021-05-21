package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BookRepository;

@Component
@Primary
public class MongodbBookRepository implements BookRepository {

	// @Primary In order to give high priority to a bean where there are multiple
	// beans of the same type
	private final SpringDataMongodbBookRepository bookDatabaseRepository;

	@Autowired
	public MongodbBookRepository(SpringDataMongodbBookRepository bookDatabaseRepository) {
		// TODO Auto-generated constructor stub
		this.bookDatabaseRepository = bookDatabaseRepository;
	}

	@Override
	public Optional<Book> findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Book>> findByBibliotec(UUID bibliotescId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book saveBook(Book book, UUID bibliotecId) {
		// TODO Auto-generated method stub
		return null;
	}

}
