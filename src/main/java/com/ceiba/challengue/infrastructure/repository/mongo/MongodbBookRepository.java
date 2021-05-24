package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BookMongoSchema;

@Component
@Primary
public class MongodbBookRepository
		implements BookRepository {

	// @Primary In order to give high priority to a bean where there are multiple
	// beans of the same type
	private final SpringDataMongodbBookRepository bookDatabaseRepository;

	@Autowired
	public MongodbBookRepository(
			SpringDataMongodbBookRepository bookDatabaseRepository) {
		// TODO Auto-generated constructor stub
		this.bookDatabaseRepository = bookDatabaseRepository;
	}

	@Override
	public Optional<Book> findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Book>> findByBibliotec(
			UUID bibliotescId) {

		return null;
	}

	@Override
	public Book saveBook(BookDTO book) {
		BookMongoSchema bookSchema = new BookMongoSchema(
				book.getName(), book.getPrice(),
				book.getActive(), book.getEnteredOn());
		if (book.getId() != null) {
			bookSchema.setId(book.getId());
		}
		bookSchema = this.bookDatabaseRepository
				.save(bookSchema);
		Book domainBook = new Book(bookSchema.getId(),
				bookSchema.getName(), bookSchema.getPrice(),
				bookSchema.getActive(),
				bookSchema.getEnteredOn());
		return domainBook;
	}

	@Override
	public List<Book> saveAllBooks(List<BookDTO> booksDto) {
		List<BookMongoSchema> mongoSchemaBooks = booksDto
				.stream()
				.map(m -> new BookMongoSchema(m.getName(),
						m.getPrice(), m.getActive(),
						m.getEnteredOn()))
				.collect(Collectors.toList());
		mongoSchemaBooks = this.bookDatabaseRepository
				.saveAll(mongoSchemaBooks);
		List<Book> domainBooks = mongoSchemaBooks.stream()
				.map(m -> {
					return new Book(m.getId(), m.getName(),
							m.getPrice(), m.getActive(),
							m.getEnteredOn());
				}).collect(Collectors.toList());
		return domainBooks;
	}

	@Override
	public List<Book> findAll() {
		List<BookMongoSchema> dbBooks = this.bookDatabaseRepository
				.findAll();
		List<Book> domainBooks = dbBooks.stream().map(m -> {
			return new Book(m.getId(), m.getName(),
					m.getPrice(), m.getActive(),
					m.getEnteredOn());
		}).collect(Collectors.toList());
		return domainBooks;
	}

	@Override
	public boolean deleteBook(String id) {
		this.bookDatabaseRepository.deleteById(id);
		return !this.bookDatabaseRepository.findById(id)
				.isPresent();

	}

}
