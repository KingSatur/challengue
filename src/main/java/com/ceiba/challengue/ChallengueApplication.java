package com.ceiba.challengue;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengueApplication {
	

	private SystemOperatorAgent agent;
	

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		SpringApplication.run(ChallengueApplication.class, args);
		final Process dateProcess = Runtime.getRuntime().exec("cmd /c date 19-05-21");
	
	}


}
