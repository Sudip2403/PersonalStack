package com.self.amazon.modules.DataStructure;

public class CalculateMaxSum {

	public static void main(String[] args) {
	/*	TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N7 = new TreeNode(15, null, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);
	*/	
		
		TreeNode N3 = new TreeNode(3, null, null);
		TreeNode N2 = new TreeNode(2, null, null);
		TreeNode N1 = new TreeNode(1, N3, N2);
		
		int s = new CalculateMaxSum().maxPathSum(N1);
		
		System.out.println(s);
	
	}
	
	
	public int maxPathSum(TreeNode root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	 
	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;
	 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
	 
		int current = Math.max(root.value, Math.max(root.value + left, root.value + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.value + right));
	 
		return current;
	}

}
