package com.mastering.spring.springboot.service;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp = new Date();
	private String message;
	private String details;

	public ExceptionResponse(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}