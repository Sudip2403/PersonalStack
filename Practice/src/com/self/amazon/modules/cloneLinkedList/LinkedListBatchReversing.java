package com.self.amazon.modules.cloneLinkedList;

public class LinkedListBatchReversing {

	public static void main(String[] args) {
		Node node = createNodes();
	
		while(null != node){
			System.out.print(node.getName());
			node = node.getNext();
			System.out.print("----->");
		}
		
		System.out.println();
		
		node = createNodes();
		ObjectPair objectPair1 = reverse(node, 3);
		
		ObjectPair objectPair2 = reverse(objectPair1.getRemain(), 3);
		objectPair1.getTail().next = objectPair2.getReversed();
		
		ObjectPair objectPair3 = reverse(objectPair2.getRemain(), 3);
		objectPair2.getTail().next = objectPair3.getReversed();
		
		node = objectPair1.getReversed();
		
		while(null != node){
			System.out.print(node.getName());
			node = node.getNext();
			System.out.print("----->");
		}	
	}

	
	private static ObjectPair reverse(Node node, int count){
		Node headUnRe = node;
		Node headRe = null;
		Node tobeRever = null;
		int c = 1;
		Node next = null;
		
		while (headUnRe != null && c++ <= count) {
			headRe = tobeRever;
			tobeRever = headUnRe;
			headUnRe = headUnRe.next;
			tobeRever.next = headRe;
			
			next = headUnRe;
		}
		headRe = tobeRever;
		return new ObjectPair(node, headRe, next);
	}

	private static Node createNodes() {

		Node headA = new Node();

		headA.setName("A");
		headA.setValue(1);

		Node B = new Node();
		B.setName("B");
		B.setValue(2);

		Node C = new Node();
		C.setName("C");
		C.setValue(3);

		Node D = new Node();
		D.setName("D");
		D.setValue(4);

		Node E = new Node();
		E.setName("E");
		E.setValue(5);

		Node F = new Node();
		F.setName("F");
		F.setValue(6);

		Node G = new Node();
		G.setName("G");
		G.setValue(7);

		headA.setNext(B);
		B.setNext(C);
		C.setNext(D);
		D.setNext(E);
		E.setNext(F);
		F.setNext(G);

		headA.setRandom(C);
		B.setRandom(F);
		D.setRandom(headA);
		E.setRandom(C);
		F.setRandom(E);
		G.setRandom(D);

		return headA;
	}

}

class ObjectPair{
	 
	Node tail;
	
	Node reversed;
	
	Node remain;

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node getReversed() {
		return reversed;
	}

	public void setReversed(Node reversed) {
		this.reversed = reversed;
	}

	public Node getRemain() {
		return remain;
	}

	public void setRemain(Node remain) {
		this.remain = remain;
	}

	public ObjectPair(Node tail, Node reversed, Node remain) {
		super();
		this.tail = tail;
		this.reversed = reversed;
		this.remain = remain;
	}

	

}

