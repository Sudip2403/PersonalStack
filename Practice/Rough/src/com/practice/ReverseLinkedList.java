package com.practice;

public class ReverseLinkedList {

	public static void main(String[] args) {
		NODE N4 = new NODE(null, 4);
		NODE N3 = new NODE(N4, 3);
		NODE N2 = new NODE(N3, 2);
		NODE N1 = new NODE(N2, 1);

		NODE r = new ReverseLinkedList().reverse(N1);
		while (r != null) {
			System.out.print(r.val + " ");
			r = r.next;
		}
	}

	NODE reverse(NODE node) {
		NODE next = null, nextN = null;
		if (node.next != null)
			next = node.next;
		if (next.next != null)
			nextN = next.next;
		node.next = null;
		while (next != null) {
			next.next = node;
			node = next;
			next = nextN;
			if (nextN != null)
				nextN = nextN.next;
		}
		return node;
	}
}

class NODE {
	NODE next;
	int val;

	public NODE(NODE next, int val) {
		super();
		this.next = next;
		this.val = val;
	}
}
