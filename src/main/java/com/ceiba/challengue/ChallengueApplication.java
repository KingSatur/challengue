package com.ceiba.challengue;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.domain.service.BibliotecService;

@SpringBootApplication
public class ChallengueApplication implements CommandLineRunner {

	@Autowired
	private BibliotecService service;

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		SpringApplication.run(ChallengueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<Bibliotec> bs = this.service.getAllBibliotec();
//		System.out.println(bs);
	}

}
