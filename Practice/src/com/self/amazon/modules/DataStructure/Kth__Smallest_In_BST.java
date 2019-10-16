package com.self.amazon.modules.DataStructure;

import java.util.Stack;

public class Kth__Smallest_In_BST {

	
	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N7 = new TreeNode(15, null, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);
		
		int small = kthSmallest(N1, 3);
		System.out.println("-----" + small);
		
		inOrderTraverse(N1, 3, 1);
		
	}

	public static int kthSmallest(TreeNode root, int k) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	 
	    TreeNode p = root;
	    int result = 0;
	 
	    while(!stack.isEmpty() || p!=null){
	        if(p!=null){
	            stack.push(p);
	            p = p.left;
	        }else{
	            TreeNode t = stack.pop();
	            k--;
	            if(k==0)
	                result = t.value;
	            p = t.right;
	        }
	    }
	 
	    return result;
	}
	
	private static void inOrderTraverse(TreeNode node, int k, int count){
		
		if(null != node.getLeft()){
			inOrderTraverse(node.getLeft(), k, count);
		}
		
		System.out.println(count + "    " +node.getValue());
		
		if(null != node.getRight()){
			inOrderTraverse(node.getRight(), k, count++);
		}
	
	}
}
