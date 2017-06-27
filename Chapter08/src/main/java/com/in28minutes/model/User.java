package com.in28minutes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "User.findUsersWithNameUsingNamedQuery", query = "select u from User u where u.name = ?1")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userid;

	private String name;

	@OneToMany(mappedBy = "user")
	private List<Todo> todos;

	public User() {// Make JPA Happy

	}

	public User(String userid, String name) {
		super();
		this.userid = userid;
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, userid=%s, name=%s, todos=%d]", id,
				userid, name, todos!=null ? todos.size()  : 0 );
	}
}
