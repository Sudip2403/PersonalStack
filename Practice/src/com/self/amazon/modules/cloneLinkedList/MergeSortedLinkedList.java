package com.self.amazon.modules.cloneLinkedList;

public class MergeSortedLinkedList {

	
	public static void main(String[] args) {
		
		NodeThis node = MergeLists(createEvenNodes(), createOddNodes());
		
		while(null != node){
			System.out.print(node.getData());
			node = node.getNext();
			System.out.print("----->");
		}
	}

	
	static NodeThis MergeLists(NodeThis list1, NodeThis list2) {
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  NodeThis head;
		  if (list1.data < list2.data) {
		    head = list1;
		  } else {
		    head = list2;
		    list2 = list1;
		    list1 = head;
		  }
		  while(list1.next != null && list2 != null) {
		    if (list1.next.data <= list2.data) {
		      list1 = list1.next;
		    } else {
		      NodeThis tmp = list1.next;
		      list1.next = list2;
		      list2 = tmp;
		    }
		  } 
		  if (list1.next == null) list1.next = list2;
		  return head;
		}
	

	private static NodeThis createEvenNodes() {

		NodeThis headA = new NodeThis();
		headA.setData(2);

		NodeThis B = new NodeThis();
		B.setData(4);

		NodeThis C = new NodeThis();
		C.setData(6);

		NodeThis D = new NodeThis();
		D.setData(8);

		NodeThis E = new NodeThis();
		E.setData(10);

		NodeThis F = new NodeThis();
		F.setData(12);

		NodeThis G = new NodeThis();
		G.setData(14);

		headA.setNext(B);
		B.setNext(C);
		C.setNext(D);
		D.setNext(E);
		E.setNext(F);
		F.setNext(G);

		
		return headA;
	}

	
	private static NodeThis createOddNodes() {

		NodeThis headA = new NodeThis();
		headA.setData(1);

		NodeThis B = new NodeThis();
		B.setData(3);

		NodeThis C = new NodeThis();
		C.setData(5);

		NodeThis D = new NodeThis();
		D.setData(7);

		NodeThis E = new NodeThis();
		E.setData(9);

		NodeThis F = new NodeThis();
		F.setData(11);

		NodeThis G = new NodeThis();
		G.setData(13);

		headA.setNext(B);
		B.setNext(C);
		C.setNext(D);
		D.setNext(E);
		E.setNext(F);
		F.setNext(G);

		
		return headA;
	}
	
	
	
	}


class NodeThis {
	int data;
	NodeThis next;

	public NodeThis() {
	}

	public NodeThis(int data, NodeThis next) {
		this();
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return this.data;
	}

	public NodeThis getNext() {
		return this.next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(NodeThis next) {
		this.next = next;
	}

}


