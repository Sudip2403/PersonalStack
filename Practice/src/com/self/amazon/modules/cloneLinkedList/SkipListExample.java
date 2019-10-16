package com.self.amazon.modules.cloneLinkedList;

public class SkipListExample {
    private static NodeS Head = null;
    private static NodeS Tail = null;
    private static NodeS Current = null;
	
    // Records previous quarter or half mark
    private static NodeS quarter = null;
    private static NodeS half = null;
	
    public static void main(String[] args) {
        int ListCount = 100;
		
        // Setup a standard double linked list manually
        for (int i = 1; i <= ListCount; i++) {
            NodeS newNode = new NodeS();
            newNode.data = i;
			
		
            // Assign to head node if this is the first node
            if (Head == null) { 
                Head = newNode; 
                Tail = newNode; 
                Current = newNode;
				
                quarter = newNode;
                half = newNode;
            }
            else {
                Current.next = newNode;
                newNode.prev = Current;
				
                // Add a quarter pointer if this node is a multiple of 25
                if ((i % 25) == 0) { 
                    newNode.prevQuarter = quarter; 
                    quarter.nextQuarter = newNode;
					
                    quarter = newNode;
                }

                // Add a half pointer if this node is a multiple of 50
                if ((i % 50) == 0) { 
                    newNode.prevHalf = half; 
                    half.nextHalf = newNode;
					
                    half = newNode;
                }
				
                // Set current node to be the next in line, set the tail
                // and then loop back around for next node.
                Current = newNode;
                Tail = newNode;
            }	
        }
		

        // Run some tests
        System.out.println("Find number 7... ");
        FindNumber(7);
		
        System.out.println("Find Number 33... ");
        FindNumber(33);
		
        System.out.println("Find number 67... ");
        FindNumber(67);
		
        System.out.println("Find number 101... ");
        FindNumber(101);	
    }
	
	
    // Searches our skip lists to locate our number
    public static void FindNumber(int num) {
        NodeS currentNode = Head;
        boolean Found = false;
		
        while (currentNode != null) {
            // Simply show what nodes we have checked in our search
            System.out.println("Checked node with data: " + currentNode.data);

            // End search if value is greater than the value we are looking for.
            if (currentNode.data > num) { break; }
			
			
            // Check our various pointers to see if a jump would get us closer.
            if (currentNode.data != num) {
                if ((currentNode.nextHalf != null) && (currentNode.nextHalf.data <= num)) { currentNode = currentNode.nextHalf; }
                else if ((currentNode.nextQuarter != null) && (currentNode.nextQuarter.data <= num)) { currentNode = currentNode.nextQuarter; }
                else { currentNode = currentNode.next; }
            }
            else {
                Found = true;
                break;
            }
        }
		
        // Report our findings
        if (Found) { System.out.println("Number Found!"); }
        else { System.out.println("Number wasn't found!"); }
    }
}


// Our NodeS object with prev/next pointers and jump pointers
class NodeS {
    public int data;
    public NodeS next = null;
    public NodeS prev = null;
	
    // Specialized skip list pointers
    public NodeS nextHalf = null;
    public NodeS prevHalf = null;
	
    public NodeS nextQuarter = null;
    public NodeS prevQuarter = null;
}