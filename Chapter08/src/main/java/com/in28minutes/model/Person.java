package com.in28minutes.model;

import javax.persistence.Id;

public class Person {

	@Id
	private String id;

	private String name;

	public Person() {// Make JPA Happy

	}

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s]", id, name);
	}
}
