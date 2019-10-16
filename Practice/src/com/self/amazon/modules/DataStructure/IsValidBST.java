package com.self.amazon.modules.DataStructure;

public class IsValidBST {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N7 = new TreeNode(15, null, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);

		
		IsValidBST isValidBST = new IsValidBST();
		isValidBST.isValidBST(N1);
	}
	
	public boolean isValidBST(TreeNode root) {
	    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
	}
	 
	public boolean isValidBST(TreeNode p, double min, double max){
	    if(p==null) 
	        return true;
	 
	    if(p.value <= min || p.value >= max)
	        return false;
	 
	    System.out.println(p.value);
	    return isValidBST(p.left, min, p.value) && isValidBST(p.right, p.value, max);
	}
}
