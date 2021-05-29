package com.ceiba.challengue.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.challengue.domain.dto.ItemBookDTO;
import com.ceiba.challengue.domain.dto.ItemBookOutDTO;
import com.ceiba.challengue.domain.model.ItemBook;
import com.ceiba.challengue.domain.service.ItemBookService;

@RestController
@RequestMapping("/itembook")
public class ItemBookRestController {

	@Autowired
	private ItemBookService service;

	@GetMapping("/{bibliotecId}")
	public ResponseEntity<?> getItemBooksByBibliotec(
			@PathVariable("bibliotecId") String bibliotecId) {
		try {
			List<ItemBookOutDTO> itemBooks = this.service
					.getItemBooksByBibliotec(bibliotecId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(itemBooks);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItemBook(
			@PathVariable String id) {
		try {

			this.service.deleteById(id);
			return new ResponseEntity<Void>(
					HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Void>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> addItemsBooksBibliotec(
			@RequestBody List<ItemBookDTO> itemsDtos) {
		try {
			List<ItemBook> domainItemBooks = this.service
					.addItemBooks(itemsDtos);
			return ResponseEntity.status(HttpStatus.OK)
					.body(domainItemBooks);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
	}
}
