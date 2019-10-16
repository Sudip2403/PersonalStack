package com.self.amazon.modules.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeRightSideView {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(3, N7, N6);
		
		TreeNode N1 = new TreeNode(1, N3, N2);

		List<Integer> list = rightSideView(N1);
		
		System.out.println(list);
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	 
	    if(root == null) return result;
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	 
	    while(queue.size() > 0){
	        //get size here
	        int size = queue.size();
	 
	        for(int i=0; i<size; i++){
	            TreeNode top = queue.remove();
	 
	            //the first element in the queue (right-most of the tree)
	            if(i==0){
	                result.add(top.value);
	            }
	            //add right first
	            if(top.right != null){
	                queue.add(top.right);
	            }
	            //add left
	            if(top.left != null){
	                queue.add(top.left);
	            }
	        }
	    }
	 
	    return result;
	}
}
