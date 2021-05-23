package com.ceiba.challengue.infrastructure.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.infrastructure.repository.mongo.entity.ItemBookMongoSchema;

@Repository
public interface SpringDataMongodbItemBookRepository extends MongoRepository<ItemBookMongoSchema, String> {

}
