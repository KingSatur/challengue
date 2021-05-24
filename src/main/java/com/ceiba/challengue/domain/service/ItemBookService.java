package com.ceiba.challengue.domain.service;

import java.util.List;

import com.ceiba.challengue.domain.dto.ItemBookDTO;
import com.ceiba.challengue.domain.dto.ItemBookOutDTO;
import com.ceiba.challengue.domain.model.ItemBook;

public interface ItemBookService {

	public List<ItemBookOutDTO> getItemBooksByBibliotec(
			String bibliotecId);

	public List<ItemBook> addItemBooks(
			List<ItemBookDTO> dtos);

	public boolean deleteByBookId(String id);

}
