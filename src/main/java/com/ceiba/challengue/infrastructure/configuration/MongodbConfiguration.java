package com.ceiba.challengue.infrastructure.configuration;

import java.text.ParseException;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ceiba.challengue.SystemOperatorAgent;
import com.ceiba.challengue.infrastructure.repository.mongo.SpringDataMongodBibliotecRepository;
import com.ceiba.challengue.infrastructure.repository.mongo.SpringDataMongodbBookRepository;

@EnableMongoRepositories(basePackageClasses = { SpringDataMongodbBookRepository.class,
		SpringDataMongodBibliotecRepository.class })
public class MongodbConfiguration {

}
