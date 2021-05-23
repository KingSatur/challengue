package com.ceiba.challengue.domain.service;

import java.util.List;
import java.util.UUID;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;

public interface BibliotecService{

	public Bibliotec createBibliotec(BibliotecDTO bibliotecDto);

	public List<Bibliotec> getAllBibliotec();

}
