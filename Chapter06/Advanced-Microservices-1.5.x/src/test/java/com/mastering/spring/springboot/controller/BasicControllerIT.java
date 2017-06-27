package com.mastering.spring.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {
	private static final String LOCAL_HOST = "http://localhost:";
	@LocalServerPort
	private int port;

	@Test
	public void welcome() throws Exception {
		ResponseEntity<String> response = getOAuthTemplate().getForEntity(createURL("/welcome"), String.class);
		assertThat(response.getBody(), equalTo("Hello World"));
	}

	@Test
	public void welcomeWithObject() throws Exception {
		ResponseEntity<String> response = getOAuthTemplate().getForEntity(createURL("/welcome-with-object"), String.class);
		assertThat(response.getBody(), containsString("Hello World"));
	}

	@Test
	public void welcomeWithParameter() throws Exception {
		ResponseEntity<String> response = getOAuthTemplate().getForEntity(createURL("/welcome-with-parameter/name/Buddy"),
				String.class);
		assertThat(response.getBody(), containsString("Hello World, Buddy"));
	}

	private OAuth2RestTemplate getOAuthTemplate() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("user-name");
		resource.setPassword("user-password");
		resource.setAccessTokenUri(createURL("/oauth/token"));
		resource.setClientId("clientId");
		resource.setClientSecret("clientSecret");
		resource.setGrantType("password");
		OAuth2RestTemplate oauthTemplate = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext());
		return oauthTemplate;
	}

	private String createURL(String uri) {
		return LOCAL_HOST + port + uri;
	}


}