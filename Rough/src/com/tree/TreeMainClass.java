package com.tree;

import java.util.Iterator;

public class TreeMainClass {
	static LinkedBinaryTree myTree = new LinkedBinaryTree();

	public static void main(String[] args) throws NonEmptyTreeException,
			InvalidPositionException, BoundaryViolationException {
		createTree();
		printInorder();

	}

	// method to create and build a tree.
	public static BTNode createTree() throws NonEmptyTreeException,
			InvalidPositionException {
		BTNode root = (BTNode) myTree.addRoot(50);
		BTNode leftChild = (BTNode) myTree.insertLeft(root, 23);
		BTNode rightChild = (BTNode) myTree.insertRight(root, 46);
		myTree.insertLeft(leftChild, 35);
		myTree.insertRight(leftChild, 28);
		myTree.insertLeft(rightChild, 12);
		myTree.insertRight(rightChild, 29);
		return root;
	}

	public static void printInorder() throws InvalidPositionException,
			BoundaryViolationException {
		Iterator it = myTree.elements();
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}
}
