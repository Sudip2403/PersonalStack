package com.self.amazon.modules.cloneLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node node = createNodes();
		while(null != node){
			System.out.print(node.getName());
			node = node.getNext();
			System.out.print("----->");
		}
		
		node = createNodes();
		Node headUnRe = node;
		Node headRe = null;
		Node tobeRever = null;

		while (headUnRe != null) {
			headRe = tobeRever;
			tobeRever = headUnRe;
			headUnRe = headUnRe.next;
			tobeRever.next = headRe;
		}
		headRe = tobeRever;

		
		System.out.println();
		
		while(null != headRe){
			if(null != headRe.getName()){
				System.out.print(headRe.getName());
			}
			headRe = headRe.getNext();
			System.out.print("----->");
		}
		
	}

	private static Node cloneNode(Node head) {

		Node node = head;
		while (null != node.getNext()) {
			Node clone = copyNode(node);
			node.setNext(clone);
			node = clone.getNext();
		}

		Node node1 = head;
		int count = 1;
		Node random = null;

		while (null != node1.getNext()) {
			if (count % 2 == 1) {
				random = node1.getRandom();
			} else if (count % 2 == 0) {
				if (null != random && null != random.getNext()) {
					node1.setRandom(random.getNext());
				}
			}
			node1 = node1.getNext();
			count++;
		}

		Node node2 = head;
		int count2 = 1;
		Node itrClone = new Node();
		itrClone.setName(head.getNext().getName());
		itrClone.setRandom(head.getNext().getRandom());
		itrClone.setValue(head.getNext().getValue());

		while (null != node2.getNext()) {
			if (count2 % 2 == 0) {
				if (null != node2.getNext().getNext()) {
					Node n = node2.getNext().getNext();

					Node n1 = itrClone;
					while (null != n1.getNext()) {
						n1 = n1.next;
					}
					if (null != n1) {
						n1.setName(n.getName());
						n1.setRandom(n.getRandom());
						n1.setValue(n.getValue());
					}
				}
			}
			count2++;
		}

		return itrClone;
	}

	private static Node copyNode(Node node) {
		Node copy = new Node();
		copy.setName(node.getName() + "`");
		copy.setNext(node.getNext());
		copy.setValue(node.getValue());
		return copy;
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
