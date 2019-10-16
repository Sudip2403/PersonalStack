package com.self.amazon.modules.SelfPractice.whitePaper;


class NodeC{
	String val;
	NodeC next;
	NodeC random;

	public NodeC(String val, NodeC next){
		this.val = val;
		this.next = next;
	}
	
	public void setRandom(NodeC random){
		this.random = random;
	}
	
	public NodeC getRandom(){
		return random;
	}
}


public class CloneLinkedListInPlace{

	public static void main(String[] args){
		NodeC n4 = new NodeC("4", null);
		NodeC n3 = new NodeC("3", n4);
		NodeC n2 = new NodeC("2", n3);
		NodeC head = new NodeC("1", n2);
		
		head.random = n3;
		n2.random = n4;
		n3.random = n2;
		n4.random = head;
		
		NodeC n = head;
		
		while(n != null){
			String r = n.random != null ? n.random.val: "";
			System.out.print("->" + n.val + "(" + r  + ")");
			n = n.next;
		}
		
		NodeC c = clone(head);
		System.out.println();
		System.out.println("-------After Clone-----------------");
		while(c != null){
			String r = c.random != null ? c.random.val: "";
			System.out.print("->" + c.val + "(" +  r + ")");
			c = c.next;
		}
	}

	private static NodeC clone(NodeC n){
		
		if(n == null) return null;
		
		NodeC node = n;
		
		//insert new nodes
		while(node != null){
			NodeC ne = node.next;
			NodeC nc = copyNode(node);
			node.next = nc;
			nc.next = ne;
			if(node.next != null)
				node = node.next.next;
			else
				node = node.next;
		}
		
		//move the random pointers of the new nodes
		node = n;
		while(node != null){
			NodeC r = node.random;
			if(r != null){
				NodeC rn = r.next;
				node.random = rn;
			}
			node = node.next;
		}
		
		// pick up only the new nodes
		node = n.next;
		NodeC head = node;
		
		while(node != null && node.next != null){
			NodeC p = node.next.next;
			node.next = p;
			node = node.next;
		}
		
		return head;
	}
	
	
	private static NodeC copyNode(NodeC node){
		NodeC newNode = new NodeC(node.val + "!", null);
		newNode.random = node.random;
		return newNode;
	}

}