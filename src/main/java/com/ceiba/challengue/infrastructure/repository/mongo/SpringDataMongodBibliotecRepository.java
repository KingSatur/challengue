package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.infrastructure.repository.mongo.entity.BibliotecMongoSchema;


@Repository
public interface SpringDataMongodBibliotecRepository extends MongoRepository<BibliotecMongoSchema, String> {

}
