package com.cg.drinkdelight.exception;

@SuppressWarnings("serial")
public class UserNameAlreadyExistsException extends RuntimeException {
	public UserNameAlreadyExistsException(String msg)
	  {
		  super(msg);
	  }

}
