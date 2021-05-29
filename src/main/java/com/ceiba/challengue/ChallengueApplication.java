package com.ceiba.challengue;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceiba.challengue.domain.service.BibliotecService;

@SpringBootApplication
public class ChallengueApplication
		implements CommandLineRunner {

	@Autowired
	private BibliotecService service;

	public static void main(String[] args)
			throws ParseException, IOException,
			InterruptedException {
		SpringApplication.run(ChallengueApplication.class,
				args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
