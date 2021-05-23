package com.ceiba.challengue.infrastructure.repository.mongo.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Book;

@Document(collection = "bibliotecs")
public class BibliotecMongoSchema {

	@Id
	private String id;
	private String name;
	@Field(name = "founded_in")
	private Integer foundedIn;


	public BibliotecMongoSchema(String name, Integer foundedIn) {
		super();
		this.name = name;
		this.foundedIn = foundedIn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFoundedIn() {
		return foundedIn;
	}

	public void setFoundedIn(Integer foundedIn) {
		this.foundedIn = foundedIn;
	}
}
