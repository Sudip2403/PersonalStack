package com.tree;

public interface BTPosition extends Position{

	public void setLeft(BTPosition p);
	public BTPosition getLeft();
	public void setRight(BTPosition p);
	public BTPosition getRight();
	public void setParent(BTPosition p);
	public BTPosition getParent();
	public Object element() throws InvalidPositionException;
}
