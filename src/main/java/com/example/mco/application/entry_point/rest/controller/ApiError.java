package com.example.mco.application.entry_point.rest.controller;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(final HttpStatus status, final String message, final List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = new ArrayList<>();
		if (errors != null && !errors.isEmpty()) {
			this.errors.addAll(errors);
		}
	}

	public ApiError(final HttpStatus status, final String message, final String error) {
		super();
		this.status = status;
		this.message = message;
		this.errors = new ArrayList<>();
		if (error != null && !error.isEmpty()) {
			this.errors.add(error);
		}
	}

	public List<String> getErrors() {
		return new ArrayList<>(errors);
	}
}
