package com.ceiba.challengue.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;

public interface BibliotecRepository {

	public Optional<Bibliotec> findById(String id);

	public Bibliotec create(BibliotecDTO bibliotecDTO);
	
	public List<Bibliotec> findAll();

}
