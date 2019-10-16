package com.self.amazon.modules.linkedList;

public class ReverseLinkedList {

	
	public static void main(String[] args) {
		Node N5 = new Node(5, null);
		Node N4 = new Node(4, N5);
		Node N3 = new Node(3, N4);
		Node N2 = new Node(2, N3);
		Node N1 = new Node(1, N2);
		
		System.out.println("----------------------------------------------------");
		Node T = N1;
		while(T != null ){
			System.out.println(T.value);
			T = T.next;
		}
		System.out.println("----------------------------------------------------");
		
		Node R = reverse(N1);
		
		Node P = R;
		while(P != null ){
			System.out.println(P.value);
			P = P.next;
		}
		System.out.println("----------------------------------------------------");
		
	}
	
	private static Node reverse(Node node){
		
		Node p1 = node;
		Node p2 = node.next;
		
		node.next = null;
		while(p1 != null && p2 != null){
			Node t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}
		
		return p1;
	}
}
