package com.self.amazon.modules.cloneLinkedList;

public class SortLinkedList {


	
	public static void main(String[] args) {
		
		NodeThis node = createUnsortedNodes();
		
		while(null != node){
			System.out.print(node.getData());
			node = node.getNext();
			System.out.print("----->");
		}
		
		System.out.println();
		node = createUnsortedNodes();
		NodeThis sort = sortNode(node);
		
		while(null != sort){
			System.out.print(sort.getData());
			sort = sort.getNext();
			System.out.print("----->");
		}

	}

	
	static NodeThis sortNode(NodeThis node){
		if(null == node) return node;
		
		NodeThis l1 = node;
		NodeThis l2 = null;
		
		while(null != node){
			NodeThis tmp = node;
			node = node.getNext();
			if(node.getData() < tmp.getData()){
				tmp.next = null;
				l2 = node;
				break;
			}
		}
		
		NodeThis head = l1;		
		while(null != l1.getNext() && null != l2){
			if(l1.getNext().getData() <= l2.getData()){
				l1 = l1.getNext();
			}else{
				NodeThis temp = l1.next;
				l1.next = l2;
				l2 = temp;
			}
		}
		
		if(l1.next == null) l1.next = l2;
		
		return head;
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
	

	private static NodeThis createUnsortedNodes() {

		NodeThis headA = new NodeThis();
		headA.setData(1);

		NodeThis B = new NodeThis();
		B.setData(3);

		NodeThis C = new NodeThis();
		C.setData(2);

		NodeThis D = new NodeThis();
		D.setData(4);

		NodeThis E = new NodeThis();
		E.setData(0);

		/*NodeThis F = new NodeThis();
		F.setData(8);

		NodeThis G = new NodeThis();
		G.setData(7);
*/
		headA.setNext(B);
		B.setNext(C);
		C.setNext(D);
		D.setNext(E);
		/*E.setNext(F);
		F.setNext(G);
*/
		
		return headA;
	}
}
