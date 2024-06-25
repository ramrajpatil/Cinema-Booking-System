package com.cbs.custom.exception;

@SuppressWarnings("serial")
public class MovieHandlingException extends RuntimeException {

	public MovieHandlingException(String message) {
		super(message);
	}
}
