package com.self.amazon.modules.SelfPractice;

import java.util.ArrayList;
import java.util.List;

public class AllPathsInBinaryTree {

	public static void main(String[] args) {
		TreeNode N7 = new TreeNode(7, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N3 = new TreeNode(3, N6, N7);
		TreeNode N2 = new TreeNode(2, N4, N5);
		TreeNode N1 = new TreeNode(1, N2, N3);

		List<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
		paths(N1, new ArrayList<Integer>(), allPaths);
		
		System.out.println(allPaths);
	}
	
	
	private static void paths(TreeNode node, ArrayList<Integer> path, List<ArrayList<Integer>> allPaths){
		
		if(node == null)
			return;
		
		path.add(node.val);
		
		if(node.left == null && node.right == null){
			allPaths.add(new ArrayList<Integer>(path));
		}
			
		paths(node.left, path, allPaths); 
		paths(node.right, path, allPaths);
		path.remove(path.size() - 1);
		
	}
}
