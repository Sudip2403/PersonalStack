package com.self.amazon.modules.SelfPractice;

public class ReverseLinkedList {

	
	public static void main(String[] args) {
		Node N4 = new Node(4, null, null);
		Node N3 = new Node(3, N4, null);
		Node N2 = new Node(2, N3, null);
		Node N1 = new Node(1, N2, null);
		
		Node r = reverse(N1);
		
		while(r != null){
			System.out.println(r.val);
			r = r.next;
		}
		
		System.out.println();
	}
	
	private static Node reverse(Node node){
	
		Node t = node;
		Node n = t.next;
		t.next = null;
		
		while(null != t && null != n){
			Node m = n.next;
			n.next = t;
			t = n;
			n = m;
			
			if(null != n)
				m = n.next;
		}
		return t;
	}
}
