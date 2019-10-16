package com.self.amazon.modules.DataStructure;

import java.util.Stack;

public class FlattenTree {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N7 = new TreeNode(15, null, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);

		flatten(N1);
		System.out.println();
	}
	
	 public static void flatten(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode p = root;
	 
	        while(p != null || !stack.empty()){
	 
	            if(p.right != null){
	                stack.push(p.right);
	            }
	 
	            if(p.left != null){
	                p.right = p.left;
	                p.left = null;
	            }else if(!stack.empty()){
	                TreeNode temp = stack.pop();
	                p.right=temp;
	            }
	 
	            p = p.right;
	        }
	    }
}
