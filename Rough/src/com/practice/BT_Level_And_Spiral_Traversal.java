package com.practice;

import java.util.Stack;


public class BT_Level_And_Spiral_Traversal {

	public static void main(String[] args) {
		
		BTNode root = createTree();
		Stack<BTNode> innerNodes = new Stack<BTNode>();
		innerNodes.push(root);
		spiralTraverse(false, new Stack<BTNode>(), innerNodes);
		//levelTraverse(new Stack<BTNode>(), innerNodes);
	}

	private static void levelTraverse(Stack<BTNode> btNodes, Stack<BTNode> innerNodes){
		while(!innerNodes.isEmpty()){
			BTNode x = innerNodes.pop();
			btNodes.push(x);
		}
		int i  = btNodes.size();
		while(i != 0){
			BTNode y = btNodes.get(--i);
			if(null != y.getLeft())
				innerNodes.push(y.getLeft());
			if(null != y.getRight())
				innerNodes.push(y.getRight());
		}
		while(!btNodes.isEmpty()){
			System.out.println(btNodes.pop().getKey());
		}
		if(!innerNodes.isEmpty()){
			levelTraverse(btNodes, innerNodes);			
		}
	
	}

	
	private static void spiralTraverse(boolean isReverseTrav, Stack<BTNode> btNodes, Stack<BTNode> innerNodes){
		isReverseTrav = !isReverseTrav;
		while(!innerNodes.isEmpty()){
			BTNode x = innerNodes.pop();
			btNodes.push(x);
		}
		int i  = 0;
		while(i < btNodes.size()){
			BTNode y = btNodes.get(i++);
			if(isReverseTrav){
				if(null != y.getRight())
					innerNodes.push(y.getRight());
				if(null != y.getLeft())
					innerNodes.push(y.getLeft());
			}else{
				if(null != y.getLeft())
					innerNodes.push(y.getLeft());
				if(null != y.getRight())
					innerNodes.push(y.getRight());
			}
		}
		while(!btNodes.isEmpty()){
			System.out.println(btNodes.pop().getKey());
		}
		if(!innerNodes.isEmpty()){
			spiralTraverse(isReverseTrav, btNodes, innerNodes);			
		}
	}
	
	
	private static void inOrderTraverse(BTNode node){
		if(null != node.getLeft()){
			inOrderTraverse(node.getLeft());
		}
		
		System.out.println(node.getKey());
		
		if(null != node.getRight()){
			inOrderTraverse(node.getRight());
		}
	}
	
	private static BTNode createTree(){
		BTNode root = new BTNode("A", 1);
		root.setLeft(new BTNode("B", 2));
		root.setRight(new BTNode("C", 3));
		root.getLeft().setLeft(new BTNode("D", 4));
		root.getLeft().setRight(new BTNode("E", 5));
		root.getRight().setLeft(new BTNode("F", 6));
		root.getRight().setRight(new BTNode("G", 7));
		
		
		root.getLeft().getLeft().setLeft(new BTNode("H", 4));
		root.getLeft().getLeft().setRight(new BTNode("I", 4));
		
		root.getLeft().getRight().setLeft(new BTNode("J", 5));
		root.getLeft().getRight().setRight(new BTNode("K", 5));
		
		
		root.getRight().getLeft().setLeft(new BTNode("L", 6));
		root.getRight().getLeft().setRight(new BTNode("M", 6));
		
		
		root.getRight().getRight().setLeft(new BTNode("N", 7));
		root.getRight().getRight().setRight(new BTNode("O", 7));
		
		return root;
	}
}


class BTNode{
	private String key;
	private int val;
	
	private BTNode left;
	private BTNode right;
	public BTNode(String key, int val) {
		super();
		this.key = key;
		this.val = val;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
}