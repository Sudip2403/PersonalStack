package com.self.amazon.modules.DataStructure;

public class LowestCommonAncestorBST {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(1, null, null);
		TreeNode N5 = new TreeNode(3, null, null);
		TreeNode N6 = new TreeNode(5, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(6, N7, N6);
		
		TreeNode N1 = new TreeNode(4, N3, N2);
		
		TreeNode t = lowestCommonAncestor(N1, N4, N5);
		
		System.out.println(t.getValue());
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    TreeNode m = root;
	 
	    if(m.value > p.value && m.value < q.value){
	        return m;  
	    }else if(m.value>p.value && m.value > q.value){
	        return lowestCommonAncestor(root.left, p, q);
	    }else if(m.value<p.value && m.value < q.value){
	        return lowestCommonAncestor(root.right, p, q);
	    }
	 
	    return root;
	}
}
