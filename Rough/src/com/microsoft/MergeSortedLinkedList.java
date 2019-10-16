package com.microsoft;

public class MergeSortedLinkedList {

	public static void main(String[] args) {
		LL l5 = new LL(5, null);
		LL l3 = new LL(3, l5);
		LL l1 = new LL(1, l3);
		
		LL l6 = new LL(6, null);
		LL l4 = new LL(4, l6);
		LL l2 = new LL(2, l4);
		
		LL l = merge(l1, l2);
		
		while(null != l){
			System.out.print(l.val + " ");
			l = l.next;
		}
	}
	
	// n1 - 1, 3, 5
	// n2 - 2, 4, 6
	
	// n1 - 1, 2, 4, 6
	//n2 -3, 5
	
	// n1 - 1, 2, 3, 5
	//n2 - 4, 6
	
	//n1 - 1, 2, 3, 4, 6
	// n2 - 5
	
	// n1 - 1, 2, 3, 4, 5
	// n2 - 6
	
	// n1 - 1, 2, 3, 4, 5, 6
	//n2 - null
	static LL merge(LL l1, LL l2){
		
		LL head = l1.val < l2.val ? l1 : l2;
		
		LL node1 = null;
		LL node2 = null;
		if(l1.val < l2.val){
			node1 = l1;
			node2 = l2;
		}else{
			node1 = l2;
			node2 = l1;
		}
		
		while(null != node1){
			if(null != node1 && null != node2 && null != node1.next && node2.val < node1.next.val){
				LL n = node1.next;
				node1.next = node2;
				node2 = n;
			}
			if(null == node1.next && null != node2){
				node1.next = node2;
				node2 = null;
			}
			node1 = node1.next;
		}
		
		return head;
	}
	
}


class LL{
	int val;
	LL next;
	public LL(int val, LL next) {
		super();
		this.val = val;
		this.next = next;
	}
}