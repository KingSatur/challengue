package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BibliotecMongoSchema;

@Component
@Primary
public class MongodbBibliotecRepository
		implements BibliotecRepository {

	// @Primary In order to give high priority to a bean where there are multiple
	// beans of the same type
	private final SpringDataMongodBibliotecRepository bibliotecDatabaseRepository;

	@Autowired
	public MongodbBibliotecRepository(
			SpringDataMongodBibliotecRepository bibliotecDatabaseRepository) {
		// TODO Auto-generated constructor stub
		this.bibliotecDatabaseRepository = bibliotecDatabaseRepository;
	}

	@Override
	public List<Bibliotec> findAll() {
		List<BibliotecMongoSchema> databaseBibliotecs = this.bibliotecDatabaseRepository
				.findAll();
		List<Bibliotec> domainBibliotecs = databaseBibliotecs
				.stream().map(m -> {
					return new Bibliotec(m.getId(),
							m.getName(), m.getFoundedIn(),
							new ArrayList<>());
				}).collect(Collectors.toList());
		return domainBibliotecs;
	}

	@Override
	public Bibliotec save(BibliotecDTO bibliotec) {
		BibliotecMongoSchema schema = new BibliotecMongoSchema(
				bibliotec.getName(),
				bibliotec.getFoundedIn());
		if (bibliotec.getId() != null) {
			schema.setId(bibliotec.getId());
		}
		schema = this.bibliotecDatabaseRepository
				.save(schema);
		return new Bibliotec(schema.getId(),
				schema.getName(), schema.getFoundedIn(),
				new ArrayList<>());

	}

	@Override
	public Optional<Bibliotec> findById(String id) {
		return null;

	}

}
