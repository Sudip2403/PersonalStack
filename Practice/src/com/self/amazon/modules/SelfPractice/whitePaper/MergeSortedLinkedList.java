package com.self.amazon.modules.SelfPractice.whitePaper;


public class MergeSortedLinkedList{
    
    
    public static void main(String[] args){
         NodePP N7 = new NodePP(7, null);
         NodePP N5 = new NodePP(5, N7);
         NodePP N3 = new NodePP(3, N5);
         NodePP N1 = new NodePP(1, N3); 

         NodePP N6 = new NodePP(6, null);
         NodePP N4 = new NodePP(4, N6);
         NodePP N2 = new NodePP(2, N4);
                  
         NodePP n = mergeLinkedList(N1, N2);
         
         System.out.println();
         
    }
    
    public static NodePP mergeLinkedList(NodePP n1, NodePP n2){
        
        if(n1 == null && n2 == null) return null;
        if(n1 == null && n2 != null) return n2;
        if(n2 == null && n1 != null) return n1;
        
        NodePP h = n1;
        
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                NodePP temp = n1.next;
                n1.next = n2;
                n2 = temp;
           }
           n1 = n1.next;
        }
            
        if(n2 != null) n1.next = n2;
        return h;
    }
}


class NodePP{
    int val;
    NodePP next;

    public NodePP(int val, NodePP next){
        this.val = val;
        this.next = next;
    }
}

