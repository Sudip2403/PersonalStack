package com.practice;

public class RecoverBST {

	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		
		print(root);
		System.out.println();
		new RecoverBST().recoverTree(root);
		print(root);
	}
	
	public void recoverTree(TreeNode root) {
		checkLeft(root);
		checkRight(root);
	}

	public TreeNode checkLeft(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = checkLeft(root.left);
		checkLeft(root.right);
		if (left != null && left.val > root.val) {
			int t = left.val;
			left.val = root.val;
			root.val = t;
			checkRight(root);
		}
		return root.right == null ? root : root.right;
	}

	public TreeNode checkRight(TreeNode root) {
		if (root == null)
			return null;
		checkRight(root.left);
		TreeNode right = checkRight(root.right);
		if (right != null && right.val < root.val) {
			int t = right.val;
			right.val = root.val;
			root.val = t;
			checkLeft(root);
		}
		return root.left == null ? root : root.left;
	}

	static void print(TreeNode node){
		if(node == null)
			return;
		print(node.left);
		System.out.print(node.val + " ");
		print(node.right);
	}
	
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
