package com.interview.task.app.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CreationFailedException extends RuntimeException{
	private static final long serialVersionUID =1L;
	
	public CreationFailedException(String message) {
		super(message);
	}
	
	public CreationFailedException(String message, Throwable throwable) {
		super(message,throwable);
	}
}
