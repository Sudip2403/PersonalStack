package com.self.amazon.modules.DataStructure;

import java.util.ArrayList;

public class SumRootToLeaf {

	
	public static void main(String[] args) {
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N7 = new TreeNode(7, null, null);
		
		TreeNode N2 = new TreeNode(2, N5, N4);
		TreeNode N3 = new TreeNode(3, N7, N6);
		
		TreeNode N1 = new TreeNode(1, N3, N2);
		
		int n = new SumRootToLeaf().sumNumbers(N1);
		System.out.println(n);
		
	}
	
	public int sumNumbers(TreeNode root) {
	    int result = 0;
	    if(root==null)
	        return result;
	 
	    ArrayList<ArrayList<TreeNode>> all = new ArrayList<ArrayList<TreeNode>>();
	    ArrayList<TreeNode> l = new ArrayList<TreeNode>();
	    l.add(root);
	    dfs(root, l, all);
	 
	    for(ArrayList<TreeNode> a: all){
	        StringBuilder sb = new StringBuilder();
	        for(TreeNode n: a){
	            sb.append(String.valueOf(n.value));
	        }
	        int currValue = Integer.valueOf(sb.toString());
	        result = result + currValue;
	    }
	 
	    return result;
	}
	 
	public void dfs(TreeNode n, ArrayList<TreeNode> l,  ArrayList<ArrayList<TreeNode>> all){
	    if(n.left==null && n.right==null){
	        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
	        t.addAll(l);
	        all.add(t);
	    }
	 
	    if(n.left!=null){
	        l.add(n.left);
	        dfs(n.left, l, all);
	        l.remove(l.size()-1);
	    }
	 
	    if(n.right!=null){
	        l.add(n.right);
	        dfs(n.right, l, all);
	        l.remove(l.size()-1);
	    }
	 
	}
}
