package com.self.amazon.modules.DataStructure;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;
	
	
	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(3, N7, N6);
		
		TreeNode N1 = new TreeNode(1, N3, N2);
		
		BSTIterator bstIterator = new BSTIterator(N1);
	
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
	}
	 
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public int next() {
		TreeNode node = stack.pop();
		int result = node.value;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
}
