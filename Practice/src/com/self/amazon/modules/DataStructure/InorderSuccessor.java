package com.self.amazon.modules.DataStructure;

import java.util.Stack;

public class InorderSuccessor {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(3, N7, N6);
		
		TreeNode N1 = new TreeNode(1, N3, N2);
		
		TreeNode node = inorderSuccessor(N1, N2);
		System.out.println(node.value);
	}
	
	
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    if(root==null || p==null)
	        return null;
	 
	    stack.push(root);
	    boolean isNext = false;
	    while(!stack.isEmpty()){
	        TreeNode top = stack.pop();
	 
	        if(top.right==null&&top.left==null){
	            if(isNext){
	                return top;
	            }
	 
	            if(p.value==top.value){
	                isNext = true;
	            }
	            continue;
	        }
	 
	        if(top.right!=null){
	            stack.push(top.right);
	            top.right=null;
	        }
	 
	        stack.push(top);
	 
	        if(top.left!=null){
	            stack.push(top.left);
	            top.left=null;
	        }
	    }
	 
	    return null;
	}
}
