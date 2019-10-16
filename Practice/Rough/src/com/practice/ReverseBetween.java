package com.practice;

public class ReverseBetween {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode r = new ReverseBetween().reverseBetween(head, 2, 2);
		while (r != null) {
			System.out.print(r.val + " ");
			r = r.next;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(n < m)
			return head;
		ListNode node = head;
		ListNode pnode = null;
		int k = m;
		while (k > 1) {
			pnode = node;
			node = node.next;
			k--;
		}
		ListNode next = null;
		ListNode start = node;
		if (node != null) {
			next = node.next;
		}
		while (n - m > 0) {
			ListNode temp = null;
			if (next != null)
				temp = next.next;
			next.next = node;
			node = next;
			next = temp;
			n--;
		}
		if (start != null)
			start.next = next;
		if (pnode != null) {
			pnode.next = node;
			return head;
		}
		return node;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
