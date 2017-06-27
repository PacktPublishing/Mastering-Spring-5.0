package com.in28minutes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.in28minutes.model.Person;

public interface PersonMongoDbRepository extends MongoRepository<Person, String> {
	List<Person> findByName(String name);
	Long countByName(String name);
}
