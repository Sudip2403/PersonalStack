package com.self.amazon.modules.SelfPractice.whitePaper;

class Node{

	int val;
	Node left;
	Node right;
	
	public Node(int val, Node left, Node right){
		this.val = val;
		this. left = left;
		this. right = right;
	}
}

public class TreeMirror{


	public static void main(String[] args){
		Node N7 = new Node(7, null, null);
		Node N6 = new Node(6, null, null);
		Node N5 = new Node(5, null, null);
		Node N4 = new Node(4, null, null);
		Node N3 = new Node(3, N6, N7);
		Node N2 = new Node(2, N4, N5);
		Node N1 = new Node(1, N2, N3);
		
		mirrorTree(N1);
		
		System.out.println();
	}

	private static Node mirrorTree(Node node){
		if(node == null) return node;
		
		if(node != null){
			Node left = mirrorTree(node.left);
			Node right = mirrorTree(node.right);
			node.left = right;
			node.right = left;
		}
		
		return node;
	}
}