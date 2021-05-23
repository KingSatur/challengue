package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BibliotecMongoSchema;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BookMongoSchema;

@Component
@Primary
public class MongodbBibliotecRepository implements BibliotecRepository {

	// @Primary In order to give high priority to a bean where there are multiple
	// beans of the same type
	private final SpringDataMongodBibliotecRepository bibliotecDatabaseRepository;

	@Autowired
	public MongodbBibliotecRepository(SpringDataMongodBibliotecRepository bibliotecDatabaseRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecDatabaseRepository = bibliotecDatabaseRepository;
	}

	@Override
	public Optional<Bibliotec> findById(UUID id) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Bibliotec> findAll() {
		// TODO Auto-generated method stub
		List<BibliotecMongoSchema> bibliotecsFromDb = this.bibliotecDatabaseRepository.findAll();
		List<Bibliotec> bibliotecs = bibliotecsFromDb.stream().map(dbItem -> {
			return new Bibliotec(dbItem.getId(), dbItem.getName(), dbItem.getFoundedIn(),
					dbItem.getBooks().stream()
							.map(m -> new Book(m.getId().toString(), m.getName(), m.getPrice(), m.getActive(), m.getEnteredOn()))
							.collect(Collectors.toList()));
		}).collect(Collectors.toList());
		return bibliotecs;
	}

	@Override
	public Bibliotec save(BibliotecDTO bibliotec) {
		List<BookMongoSchema> books = bibliotec.getBooks().stream().map(m -> {
			BookMongoSchema l = new BookMongoSchema(m.getName(), m.getPrice(), m.getActive(), m.getEnteredOn());
			l.setId(m.getId());
			return l;
		}).collect(Collectors.toList());

		BibliotecMongoSchema schema = new BibliotecMongoSchema(bibliotec.getName(), bibliotec.getFoundedIn(), books);
		schema = this.bibliotecDatabaseRepository.save(schema);
		List<Book> domainBooks = schema.getBooks().stream()
				.map(k -> new Book(k.getId(), k.getName(), k.getPrice(), k.getActive(), k.getEnteredOn()))
				.collect(Collectors.toList());
		Bibliotec b = new Bibliotec(schema.getId().toString(), schema.getName(), schema.getFoundedIn(), domainBooks);
		return b;

	}

}
