package com.self.amazon.modules.linkedList;

public class ReverseNodesInKGroups {
	
	
	
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
		
		Node R = reverseNodesInKGroups(N1, 3);
		
		Node P = R;
		while(P != null ){
			System.out.println(P.value);
			P = P.next;
		}
		System.out.println("----------------------------------------------------");
		
	}
	
	private static Node reverseNodesInKGroups(Node node, int K){
		
		if(node == null || node.next == null)
			return node;
		
		
		Node head = node;
		Node p = node;
		Node curr = head.next;
		Node ne = null;
		if(null != curr)
			ne = curr.next;
		int c = 0;
		head.next = null;
		while(curr != null && c < (K -1)){
			curr.next = head;
			head = curr;
			curr = ne;
			if(ne != null)
				ne = ne.next;
			c++;
		}
		
		p.next = reverseNodesInKGroups(curr, K);
		
		return head;
	}
}

