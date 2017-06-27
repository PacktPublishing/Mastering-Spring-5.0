package com.in28minutes.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.model.Person;

@DataMongoTest
@RunWith(SpringRunner.class)
public class PersonMongoDbRepositoryTest {

	@Autowired
	PersonMongoDbRepository personRepository;

	@Test
	public void simpleTest(){
		personRepository.deleteAll();
		personRepository.save(new Person("name1"));
		personRepository.save(new Person("name2"));
		
		for (Person person : personRepository.findAll()) {
			System.out.println(person);
		}
		
		System.out.println(personRepository.findByName("name1"));
		
		System.out.println(personRepository.count());
	}
}