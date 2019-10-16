package com.self.amazon.modules.DataStructure;

import java.util.LinkedList;

public class LongestConsecutivePath {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(5, null, null);
		TreeNode N5 = new TreeNode(9, null, null);
		TreeNode N6 = new TreeNode(11, null, null);
		TreeNode N8 = new TreeNode(17, null, null);
		TreeNode N7 = new TreeNode(15, N8, null);
		
		TreeNode N2 = new TreeNode(8, N5, N4);
		TreeNode N3 = new TreeNode(12, N7, N6);
		
		TreeNode N1 = new TreeNode(10, N3, N2);

		int n = longestConsecutive(N1);
		System.out.println(n);
		
	}
	
	public static int longestConsecutive(TreeNode root) {
	    if(root==null)
	        return 0;
	 
	    LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
	    LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
	 
	    nodeQueue.offer(root);
	    sizeQueue.offer(1);
	    int max=1;
	 
	    while(!nodeQueue.isEmpty()){
	        TreeNode head = nodeQueue.poll();
	        int size = sizeQueue.poll();
	 
	        if(head.left!=null){
	            int leftSize=size;
	            if(head.value==head.left.value-1){
	                leftSize++;
	                max = Math.max(max, leftSize);
	            }else{
	                leftSize=1;
	            }
	 
	            nodeQueue.offer(head.left);
	            sizeQueue.offer(leftSize);
	        }
	 
	        if(head.right!=null){
	            int rightSize=size;
	            if(head.value==head.right.value-1){
	                rightSize++;
	                max = Math.max(max, rightSize);
	            }else{
	                rightSize=1;
	            }
	 
	            nodeQueue.offer(head.right);
	            sizeQueue.offer(rightSize);
	        }
	 
	 
	    }
	 
	    return max;
	}
}
