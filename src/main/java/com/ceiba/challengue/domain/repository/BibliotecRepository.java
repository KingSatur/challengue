package com.ceiba.challengue.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;

public interface BibliotecRepository {

	public Optional<Bibliotec> findById(String id);

	public Bibliotec save(BibliotecDTO bibliotecDTO);

	public List<Bibliotec> findAll();

}
