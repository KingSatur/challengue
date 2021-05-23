package com.ceiba.challengue.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ceiba.challengue.ChallengueApplication;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.service.BibliotecService;
import com.ceiba.challengue.domain.service.BibliotecServiceImpl;
import com.ceiba.challengue.domain.service.BookService;
import com.ceiba.challengue.domain.service.BookServiceImpl;;

@Configuration
@ComponentScan(basePackageClasses = ChallengueApplication.class)
public class BeanConfiguration {

	@Bean
	BibliotecService bibliotecService(final BibliotecRepository bibliotecRepository,
			final BookRepository bookRepository) {
		return new BibliotecServiceImpl(bibliotecRepository, bookRepository);
	}

	@Bean
	BookService bookService(final BookRepository bookRepository) {
		return new BookServiceImpl(bookRepository);
	}

}
