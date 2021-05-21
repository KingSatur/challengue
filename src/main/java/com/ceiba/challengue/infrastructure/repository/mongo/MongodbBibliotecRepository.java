package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;

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
	public Bibliotec save(Bibliotec bibliotec) {
		// TODO Auto-generated method stub
		Bibliotec b = this.bibliotecDatabaseRepository.save(bibliotec);
		System.out.println(b);
		return b;
	}

	@Override
	public List<Bibliotec> findAll() {
		// TODO Auto-generated method stub
		return this.bibliotecDatabaseRepository.findAll();
	}

}
