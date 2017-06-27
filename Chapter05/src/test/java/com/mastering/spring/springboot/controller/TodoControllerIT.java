package com.mastering.spring.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mastering.spring.springboot.Application;
import com.mastering.spring.springboot.bean.Todo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {
	@LocalServerPort
	private int port;
	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void retrieveTodos() throws Exception {
		String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
				+ "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";
		String uri = "/users/Jack/todos";
		ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void retrieveTodo() throws Exception {
		String expected = "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}";

		ResponseEntity<String> response = template.getForEntity(createUrl("/users/Jack/todos/1"), String.class);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void addTodo() throws Exception {
		Todo todo = new Todo(-1, "Jill", "Learn Hibernate", new Date(), false);
		URI location = template.postForLocation(createUrl("/users/Jill/todos"), todo);
		assertThat(location.getPath(), containsString("/users/Jill/todos/4"));
	}

	private String createUrl(String uri) {
		return "http://localhost:" + port + uri;
	}
}