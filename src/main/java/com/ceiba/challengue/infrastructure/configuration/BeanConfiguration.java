package com.ceiba.challengue.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ceiba.challengue.ChallengueApplication;
import com.ceiba.challengue.domain.repository.BibliotecRepository;
import com.ceiba.challengue.domain.repository.BookRepository;
import com.ceiba.challengue.domain.service.BibliotecBussinesService;
import com.ceiba.challengue.domain.service.BussinesServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = ChallengueApplication.class)
public class BeanConfiguration {

	@Bean
	BibliotecBussinesService bibliotecBussinesService(final BookRepository bookRepository,
			final BibliotecRepository bibliotecRepository) {
		return new BussinesServiceImpl(bibliotecRepository, bookRepository);
	}

}
