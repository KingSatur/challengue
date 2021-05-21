package com.ceiba.challengue;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.service.BibliotecBussinesService;
import com.ceiba.challengue.domain.service.BussinesServiceImpl;
import com.ceiba.challengue.infrastructure.repository.mongo.SpringDataMongodBibliotecRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.SpringDataMongodbBookRepository;

@SpringBootApplication
public class ChallengueApplication implements CommandLineRunner {

	@Autowired
	private BibliotecBussinesService service;

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		SpringApplication.run(ChallengueApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola pa123 333");
		this.service.createBibliotec(new Bibliotec(UUID.randomUUID(), "Icesi bibliotec", 1978));
		List<Bibliotec> b = this.service.getAllBibliotec();
		System.out.println(b);
	}

}
