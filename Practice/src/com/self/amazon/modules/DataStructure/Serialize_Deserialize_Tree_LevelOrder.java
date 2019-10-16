package com.self.amazon.modules.DataStructure;

import java.util.LinkedList;

public class Serialize_Deserialize_Tree_LevelOrder {

	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(3, N7, N6);
		
		TreeNode N1 = new TreeNode(1, N3, N2);
		
		Serialize_Deserialize_Tree_LevelOrder deserialize_Tree = new Serialize_Deserialize_Tree_LevelOrder();
		deserialize_Tree.serialize(N1);
		
	}
	
	public String serialize(TreeNode root) {
	    if(root==null)
	        return null;
	 
	    StringBuilder sb = new StringBuilder();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(root);
	    while(!queue.isEmpty()){
	        TreeNode head = queue.poll();
	        if(head==null){
	            sb.append("#,");
	        }else{
	            sb.append(head.value+",");
	            queue.offer(head.left);
	            queue.offer(head.right);
	        }
	    }
	    System.out.println(sb.toString().substring(0, sb.length()-1));
	    return sb.toString().substring(0, sb.length()-1);
	}
	 
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data == null)
	        return null;
	 
	    String[] arr = data.split(",");
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	    if(arr.length==3)
	        return root;
	 
	    queue.offer(root);
	 
	    int i=1;
	    while(!queue.isEmpty()){
	        TreeNode head = queue.poll();
	 
	        if(head!=null){
	            if(arr[i].equals("#")){
	                head.left= null;
	                i++;
	            }else{
	                head.left=new TreeNode(Integer.parseInt(arr[i++]));
	            }
	 
	            if(arr[i].equals("#")){
	                head.right = null; 
	                i++;
	            }else{
	                head.right = new TreeNode(Integer.parseInt(arr[i++]));
	            }
	 
	            queue.offer(head.left);
	            queue.offer(head.right);
	        }
	    }
	 
	    return root;
	}
}
