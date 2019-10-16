package com.practice;

public class SplitLinkedListIntoParts {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);
		root.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		int k = 3;
		ListNode[] result = new SplitLinkedListIntoParts().splitListToParts(root, k);
		for (ListNode listNode : result) {
			while(listNode != null){
				System.out.print(listNode.val + " ");
				listNode = listNode.next;
			}
			System.out.println();
		}
	}

	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode node = root;
		int n = 0, q = k;
		while (node != null) {
			n++;
			node = node.next;
		}
		int[] dist = new int[k];
		int i = k - 1;
		if (k > n) {
			k = n;
			i = n - 1;
		}
		while (i >= 0) {
			dist[i] = n / k;
			n -= dist[i];
			k--;
			i--;
		}
		ListNode[] listNodes = new ListNode[q];
		int p = 0;
		while (p < q) {
			ListNode temp = root;
			ListNode start = null;
			if (temp != null)
				start = temp.next;
			while (dist[p] > 1) {
				if (temp != null)
					temp = temp.next;
				if (temp != null)
					start = temp.next;
				dist[p]--;
			}
			if (temp != null)
				temp.next = null;
			listNodes[p] = root;
			root = start;
			p++;
		}
		return listNodes;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
