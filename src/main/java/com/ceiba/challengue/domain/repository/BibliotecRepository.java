package com.ceiba.challengue.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceiba.challengue.domain.model.Bibliotec;

public interface BibliotecRepository {

	public Optional<Bibliotec> findById(UUID id);

	public Bibliotec save(Bibliotec bibliotec);
	
	public List<Bibliotec> findAll();

}
