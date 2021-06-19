package com.interview.task.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorDetails{
	private HttpStatus httpStatus;	
	private String errorMessage;
	private List<String> fieldErrors = new ArrayList<>();
	
	public ErrorDetails(HttpStatus httpStatus, String message, List<String> fieldErrors ) {
		this.httpStatus = httpStatus;
		this.errorMessage = message;
		this.fieldErrors = fieldErrors;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}

