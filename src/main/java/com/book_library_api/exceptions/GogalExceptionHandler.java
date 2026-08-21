package com.book_library_api.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GogalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public Exceptions Handler(IdNotFoundException r) {
		Exceptions exception = new Exceptions();
		exception.setError("EDX23456");
		exception.setMessage(r.getMessage());
		return exception;

	}
}
