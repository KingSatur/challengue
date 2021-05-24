package com.ceiba.challengue.domain.repository;

import java.util.List;

import com.ceiba.challengue.domain.dto.ItemBookDTO;
import com.ceiba.challengue.domain.model.ItemBook;

public interface ItemBookRepository {
	public List<ItemBook> saveItemsBooks(
			List<ItemBookDTO> itemBook);

	public List<ItemBook> getItemBooksByBibliotec(
			String bibliotecId);

	public boolean deleteByBookId(String id);

}
