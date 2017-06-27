package com.in28minutes.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.model.Todo;
import com.in28minutes.model.User;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TodoRepositoryTest {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void check_todo_count() {
		assertEquals(3, todoRepository.count());
	}

	@Test
	public void findOne() {
		Optional<Todo> todo = todoRepository.findById(101L);
		assertEquals("Todo Desc 1", todo.get().getDescription());
	}

	@Test
	public void exists() {
		assertFalse(todoRepository.existsById(105L));
		assertTrue(todoRepository.existsById(101L));
	}

	@Test
	public void delete() {
		todoRepository.deleteById(101L);
		assertEquals(2,todoRepository.count());
	}

	@Test
	public void deleteAll() {
		todoRepository.deleteAll();
		assertEquals(0,todoRepository.count());
	}

	@Test
	public void save() {
		Todo todo = todoRepository.findById(101L).get();
		todo.setDescription("Todo Desc Updated");
		todoRepository.save(todo);
		
		entityManager.flush();
		
		Todo updatedTodo = todoRepository.findById(101L).get();
		assertEquals("Todo Desc Updated",updatedTodo.getDescription());
	}

}