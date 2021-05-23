package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.model.Book;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BookMongoSchema;

@Repository
public interface SpringDataMongodbBookRepository extends MongoRepository<BookMongoSchema, String> {

}
