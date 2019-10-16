package com.self.amazon.modules.DataStructure;

public class ConvertSortedLinkedListToBST {

	static ListNode h;
	
	
	public static void main(String[] args) {
		
		/*ListNode L7 = new ListNode(7, null);
		ListNode L6 = new ListNode(6, L7);
		ListNode L5 = new ListNode(5, L6);
		ListNode L4 = new ListNode(4, L5);*/
		ListNode L3 = new ListNode(3, /*L4*/null);
		ListNode L2 = new ListNode(2, L3);
		ListNode L1 = new ListNode(1, L2);
		
		ConvertSortedLinkedListToBST bst = new ConvertSortedLinkedListToBST();
		bst.sortedListToBST(L1);
		System.out.println();
	}
	 
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
}
