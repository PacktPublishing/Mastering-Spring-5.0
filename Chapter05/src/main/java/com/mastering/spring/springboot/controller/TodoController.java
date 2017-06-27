package com.mastering.spring.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mastering.spring.springboot.bean.Todo;
import com.mastering.spring.springboot.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/users/{name}/todos")
	public List<Todo> retrieveTodos(@PathVariable String name) {
		return todoService.retrieveTodos(name);
	}

	@GetMapping(path = "/users/{name}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
		return todoService.retrieveTodo(id);
	}

	@PostMapping("/users/{name}/todos")
	ResponseEntity<?> add(@PathVariable String name, @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
		if (createdTodo == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}