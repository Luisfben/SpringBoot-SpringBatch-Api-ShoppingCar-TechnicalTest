package com.example.shoppingcart.exception;

public class InsufficientStockException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InsufficientStockException() {
		super("Insufficient Stock");
	}
}
