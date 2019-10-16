package com.self.amazon.modules.DataStructure;

public class LowestCommonAncestor {

	public static void main(String[] args) {
	
		TreeNode N4 = new TreeNode(1, null, null);
		TreeNode N5 = new TreeNode(3, null, null);
		TreeNode N6 = new TreeNode(5, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(6, N7, N6);
		
		TreeNode N1 = new TreeNode(4, N3, N2);
		
		TreeNode t = lowestCommonAncestor(N1, N4, N7);
		
		System.out.println(t.getValue());
	}
	
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q) return root;
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    if(left!=null&&right!=null) return root;
	    return left == null ? right : left;
	}
}
