package com.cg.drinkdelight.exception;

@SuppressWarnings("serial")
public class PasswordAuthenticationFailedException extends RuntimeException {
	public PasswordAuthenticationFailedException(String msg) {
		super(msg);
	}

}
