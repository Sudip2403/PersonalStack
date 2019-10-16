package com.self.amazon.modules.DataStructure;

public class TreeNode {

	int value;
	TreeNode right;
	TreeNode left;
	
	int size;

	
	public TreeNode(int value) {
		super();
		this.value = value;
	}

	public TreeNode(int value, TreeNode right, TreeNode left) {
		super();
		this.value = value;
		this.right = right;
		this.left = left;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
