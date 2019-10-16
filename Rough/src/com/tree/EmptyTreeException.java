package com.tree;

public class EmptyTreeException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyTreeException(String string) {
		super(string);
	}

	public EmptyTreeException() {
	}
}
