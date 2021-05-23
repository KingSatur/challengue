package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.ArrayList;
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
	public List<Bibliotec> findAll() {
		return null;
	}

	@Override
	public Bibliotec create(BibliotecDTO bibliotec) {
		BibliotecMongoSchema schema = new BibliotecMongoSchema(bibliotec.getName(), bibliotec.getFoundedIn());
		schema = this.bibliotecDatabaseRepository.save(schema);
		return new Bibliotec(schema.getId(), schema.getName(), schema.getFoundedIn(), new ArrayList<>());
	
	}

	@Override
	public Optional<Bibliotec> findById(String id) {
		return null;

	}

}
