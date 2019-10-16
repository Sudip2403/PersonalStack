package com.self.amazon.modules.cloneLinkedList;

public class CloneLinkedList {

	
	public static void main(String[] args) {
		Node node = createNodes();
		System.out.println("---------Original Nodes-----------\n");
		while(null != node.getNext()){
			System.out.print(node.getName());
			if(null != node.getRandom()){
				System.out.print("*" + node.getRandom().getName() + "  ");
			}
			node = node.getNext();
			System.out.print("----->");
		}
		
		System.out.println();
		Node nodeq = createNodes();
		Node clone = cloneNode(nodeq);
		System.out.println("---------Cloned Nodes-----------\n");
		while(null != clone.getNext()){
			System.out.print(clone.getName());
			if(null != clone.getRandom()){
				System.out.print("/" + node.getRandom().getName() + "  ");
			}
			clone = clone.getNext();
		}
	}

	
	private static Node cloneNode(Node head){
		
		Node node = head;
		while(null != node.getNext()){
			Node clone = copyNode(node);
			node.setNext(clone);
			node = clone.getNext();
		}
		
		
		
		Node node1 = head;
		int count = 1;
		Node random = null;
		
		while(null != node1.getNext()){
			if(count % 2 == 1){
				random = node1.getRandom();
			}else if(count % 2 == 0){
				if(null != random && null != random.getNext()){
					node1.setRandom(random.getNext());
				}
			}
			node1 = node1.getNext();
			count ++;
		}
		
		
		Node node2 = head;
		int count2 = 1;
		Node itrClone = new Node();
		itrClone.setName(head.getNext().getName());
		itrClone.setRandom(head.getNext().getRandom());
		itrClone.setValue(head.getNext().getValue());
		
		
		while(null != node2.getNext()){
			if(count2 % 2 == 0){
				if(null != node2.getNext().getNext()){
					Node n = node2.getNext().getNext();
					
					Node n1 = itrClone;
					while(null != n1.getNext()){
						n1 = n1.next;
					}
					if(null != n1){
						n1.setName(n.getName());
						n1.setRandom(n.getRandom());
						n1.setValue(n.getValue());
					}
				}
			}
			count2 ++;
		}
		
		return itrClone;
	}
	
	
	private static Node copyNode(Node node){
		Node copy = new Node();
		copy.setName(node.getName()+"`");
		copy.setNext(node.getNext());
		copy.setValue(node.getValue());
		return copy;
	}
	
	private static Node createNodes(){
		
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



class Node{
	int value;
	String name;
	
	Node next;
	Node random;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getRandom() {
		return random;
	}
	public void setRandom(Node random) {
		this.random = random;
	}
}