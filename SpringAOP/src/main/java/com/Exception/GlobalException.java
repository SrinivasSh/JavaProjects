package com.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MovieNotFoundException.class)
	public String MovieNotFoundException(MovieNotFoundException ex) {
		return ex.getMessage();
	}

}
