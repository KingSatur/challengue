package com.ceiba.challengue.domain.service;

import java.util.List;
import java.util.UUID;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;

public interface BibliotecService{

	public Bibliotec createBibliotec(BibliotecDTO bibliotecDto);

	public List<Bibliotec> getAllBibliotec();
	
	public List<Book> addBooks(List<Book> books, String bibliotecId);
	
	public Bibliotec getBibliotecById(String id);
	
	public Bibliotec editBibliotec(BibliotecDTO bibliotecDTO);

}
