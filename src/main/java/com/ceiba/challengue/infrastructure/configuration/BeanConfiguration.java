package com.ceiba.challengue.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ceiba.challengue.ChallengueApplication;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.repository.ItemBookRepository;
import com.ceiba.challengue.domain.service.BibliotecService;
import com.ceiba.challengue.domain.service.BibliotecServiceImpl;
import com.ceiba.challengue.domain.service.BookService;
import com.ceiba.challengue.domain.service.BookServiceImpl;
import com.ceiba.challengue.domain.service.ItemBookService;
import com.ceiba.challengue.domain.service.ItemBookServiceImpl;;

@Configuration
@ComponentScan(basePackageClasses = ChallengueApplication.class)
public class BeanConfiguration {

	@Bean
	BibliotecService bibliotecService(
			final BibliotecRepository bibliotecRepository,
			final BookRepository bookRepository,
			final ItemBookRepository itemBookRepository) {
		return new BibliotecServiceImpl(bibliotecRepository,
				bookRepository, itemBookRepository);
	}

	@Bean
	BookService bookService(
			final BookRepository bookRepository) {
		return new BookServiceImpl(bookRepository);
	}

	@Bean
	ItemBookService itemBookService(
			final ItemBookRepository itemBookRepository,
			final BookRepository bookRepository) {
		return new ItemBookServiceImpl(itemBookRepository,
				bookRepository);
	}

}
