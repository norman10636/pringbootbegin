package com.norman.students.exception;

public class DaoException extends RuntimeException {
	
	public DaoException() {
		super("there no such records exists!!!");
	}
}
