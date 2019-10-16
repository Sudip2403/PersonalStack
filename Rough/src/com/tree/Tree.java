package com.tree;

import java.util.Iterator;

public interface Tree {

	public int size();
	
	public boolean isEmpty();
	
	public Iterator elements() throws InvalidPositionException;

	public Iterator positions() throws InvalidPositionException;

	public Object replace(Position v, Object e) throws InvalidPositionException;

	public Position root() throws EmptyTreeException;

	public Position parent(Position v) throws InvalidPositionException;

	public Iterator children(Position v) throws InvalidPositionException;

	public boolean isInternal(Position v) throws InvalidPositionException;

	public boolean isExternal(Position v) throws InvalidPositionException;

	public boolean isRoot(Position v) throws InvalidPositionException;
}
