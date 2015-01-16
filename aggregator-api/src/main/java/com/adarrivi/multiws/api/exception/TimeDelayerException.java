package com.adarrivi.multiws.api.exception;

public class TimeDelayerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TimeDelayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeDelayerException(String message) {
		super(message);
	}

}
