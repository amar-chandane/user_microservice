package com.amartechs.user.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleanyException(Exception ex, WebRequest request) {
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null) {
			errorMessage = ex.toString();
		}

		return new ResponseEntity<>(new ErrorMessage(new Date(), errorMessage), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { NullPointerException.class, ArrayIndexOutOfBoundsException.class })
	public ResponseEntity<Object> handleanySpecificException(Exception ex, WebRequest request) {
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null) {
			errorMessage = ex.toString();
		}

		return new ResponseEntity<>(new ErrorMessage(new Date(), errorMessage), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { UserBusinessException.class })
	public ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request) {
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null) {
			errorMessage = ex.toString();
		}

		return new ResponseEntity<>(new ErrorMessage(new Date(), errorMessage), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
