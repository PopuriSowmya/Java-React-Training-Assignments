package com.hexaware.exception;

public class NegativeAmountException extends Exception{
	public NegativeAmountException(String message) {
		super(message+". Balance cannot be negative");
	}
}
