package com.interview.task.app.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
		
	 @Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> errorList = ex
	                .getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(fieldError -> fieldError.getDefaultMessage())
	                .collect(Collectors.toList());
	        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
	        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getHttpStatus(), request);
	 }
	 
	 @ExceptionHandler(value = {Exception.class})
		public ResponseEntity<Object> handleCreationAndResourceNotFoundException(Exception ex, WebRequest request){
			String errorMessageDescription = ex.getLocalizedMessage();
			if(errorMessageDescription==null) errorMessageDescription=ex.toString();
			ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, errorMessageDescription,null);
			return new ResponseEntity<>(errorDetails, new HttpHeaders(),errorDetails.getHttpStatus());
		}
	
	 
}
