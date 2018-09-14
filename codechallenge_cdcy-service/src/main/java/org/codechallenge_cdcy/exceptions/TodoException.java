package org.codechallenge_cdcy.exceptions;

public class TodoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1601375622211963479L;

	public TodoException() {
	}

	public TodoException(String message) {
		super(message);
	}

	public TodoException(Throwable cause) {
		super(cause);
	}

	public TodoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
