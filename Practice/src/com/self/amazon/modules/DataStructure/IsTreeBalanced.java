package com.self.amazon.modules.DataStructure;

public class IsTreeBalanced {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N8 = new TreeNode(17, null, null);
		TreeNode N7 = new TreeNode(15, N8, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);
		
		boolean f = new IsTreeBalanced().isBalanced(N1);
		System.out.println(f);
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
 
	}
}
