package com.tree;

public class BoundaryViolationException extends Exception {

	private static final long serialVersionUID = -2364251740207041563L;

	public BoundaryViolationException() {
		super();
	}

	public BoundaryViolationException(String message) {
		super(message);
	}
}