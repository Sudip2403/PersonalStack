package com.self.amazon.modules.SelfPractice;

public class TreeNode {

	int val;
	
	TreeNode left;
	
	TreeNode right;
	
	int height;
	
	TreeNode parent;

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
