package com.ceiba.challengue.infrastructure.repository.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.challengue.domain.model.Bibliotec;


@Repository
public interface SpringDataMongodBibliotecRepository extends MongoRepository<Bibliotec, UUID> {

}
