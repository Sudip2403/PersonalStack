package com.tree;

public interface BinaryTree extends Tree {

	public BTPosition left(BTPosition p) throws InvalidPositionException;

	public BTPosition right(BTPosition p) throws InvalidPositionException;

	public boolean hasLeft(BTPosition p) throws InvalidPositionException;

	public boolean hasRight(BTPosition p) throws InvalidPositionException;
}
