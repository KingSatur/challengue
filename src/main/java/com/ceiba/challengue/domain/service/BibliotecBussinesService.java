package com.ceiba.challengue.domain.service;

import java.util.List;
import java.util.UUID;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;

public interface BibliotecBussinesService {

	public void createBibliotec(Bibliotec bibliotec);

	public void createBook(Book book, UUID bibliotecId);

	public List<Book> getAllBookByBibliotec(UUID bibliotecId);
	
	public List<Bibliotec> getAllBibliotec();

}
