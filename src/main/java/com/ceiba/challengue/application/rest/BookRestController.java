package com.ceiba.challengue.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.service.BookService;
import com.ceiba.challengue.domain.service.ItemBookService;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookService bookService;
	@Autowired
	private ItemBookService itemBookService;

	@PostMapping
	public ResponseEntity<?> createBook(
			@RequestBody BookDTO dto) {
		try {
			Book domainBook = this.bookService
					.saveBook(dto);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(domainBook);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}

	}

	@PutMapping
	public ResponseEntity<?> updateBook(
			@RequestBody BookDTO bookDto) {
		try {
			Book book = this.bookService.saveBook(bookDto);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(book);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllBooks() {
		try {
			List<Book> books = this.bookService
					.getAllBooks();
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(books);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(
			@PathVariable("id") String id) {
		try {
			boolean taskDeleteBook = this.bookService
					.deleteBook(id);
			System.out.println(taskDeleteBook);
			if (taskDeleteBook) {
				boolean taskDeleteItemsBooks = this.itemBookService
						.deleteByBookId(id);
				return ResponseEntity.status(
						HttpStatus.INTERNAL_SERVER_ERROR)
						.body(taskDeleteBook
								&& taskDeleteItemsBooks);
			}
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(taskDeleteBook);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(
					HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
	}

}
