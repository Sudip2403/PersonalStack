package com.self.amazon.modules.SelfPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * Note pre order, post order and in order are DFS tree traversals
 * Level order and Spiral are BFS tree traversals
 * @author Sudip.Dutta
 *
 */

public class TreeTraversal {

	public static void main(String[] args) {

		TreeNode N7 = new TreeNode(7, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N3 = new TreeNode(3, N6, N7);
		TreeNode N2 = new TreeNode(2, N4, N5);
		TreeNode N1 = new TreeNode(1, N2, N3);

		System.out.println("----------pre order-----------------------");

		List<Integer> d = new ArrayList<Integer>();
		preorder(N1, d);

		for (Integer integer : d) {
			System.out.println(integer);
		}

		System.out.println("------------in order---------------------");

		List<Integer> d1 = new ArrayList<Integer>();
		inorder(N1, d1);

		for (Integer integer : d1) {
			System.out.println(integer);
		}

		System.out.println("-------------postorder--------------------");
		List<Integer> d2 = new ArrayList<Integer>();
		postorder(N1, d2);

		for (Integer integer : d2) {
			System.out.println(integer);
		}

		System.out.println("------------level order---------------------");
		
		List<Integer> d3 = new ArrayList<Integer>();
		levelorder(N1, d3);

		for (Integer integer : d3) {
			System.out.println(integer);
		}
		
		System.out.println("------------spiral order---------------------");
		
		List<Integer> d4 = new ArrayList<Integer>();
		spiralorder(N1, d4);

		for (Integer integer : d4) {
			System.out.println(integer);
		}

	}

	private static void inorder(TreeNode node, List<Integer> nodes) {

		if (node == null)
			return;
		inorder(node.left, nodes);
		nodes.add(node.val);
		inorder(node.right, nodes);
	}

	private static void preorder(TreeNode node, List<Integer> nodes) {

		if (node == null)
			return;
		nodes.add(node.val);

		preorder(node.left, nodes);
		preorder(node.right, nodes);
	}

	private static void postorder(TreeNode node, List<Integer> nodes) {

		if (node == null)
			return;
		inorder(node.left, nodes);
		inorder(node.right, nodes);
		nodes.add(node.val);
	}
	
	private static void levelorder(TreeNode node, List<Integer> nodes) {
		
		Queue<TreeNode> integers = new LinkedList<TreeNode>();
		
		if(node != null){
			integers.add(node);
			
			while(!integers.isEmpty()){
				TreeNode n = integers.poll();
				
				System.out.println(n.val);
				
				if(n.left != null)
					integers.offer(n.left);
				
				if(n.right != null)
					integers.offer(n.right);
			}
		}
		
	}
	
	
	private static void spiralorder(TreeNode node, List<Integer> nodes) {
		
		Queue<TreeNode> integers = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(node != null){
			stack.add(node);
			spiral(integers, stack, true);
		}
	}
	
	private static void spiral(Queue<TreeNode> integers, Stack<TreeNode> stack, boolean rightAndLeft){
		
		while(!stack.isEmpty()){
			TreeNode n = stack.pop();
		
			if(n == null)
				return;
			
			System.out.println(n.val);
			
			if(rightAndLeft){
				integers.offer(n.right);
				integers.offer(n.left);
			}else{
				integers.offer(n.left);
				integers.offer(n.right);
			}
		}
		
		while(!integers.isEmpty()){
			stack.add(integers.poll());
		}
		spiral(integers, stack, !rightAndLeft);
	}
}
