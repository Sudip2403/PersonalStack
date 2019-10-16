package com.self.amazon.modules.SelfPractice;

public class AVLTrees {

	
	public static void main(String[] args) {
		/*TreeNode N7 = new TreeNode(7, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N5 = new TreeNode(5, null, null);
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N3 = new TreeNode(3, N6, N7);
		TreeNode N2 = new TreeNode(2, N4, N5);
		TreeNode N1 = new TreeNode(1, N2, N3);
		
		N1.parent = null;
		N2.parent = N1;
		N3.parent = N1;
		N4.parent = N2;
		N5.parent = N2;
		N6.parent = N3;
		N7.parent = N3;*/
		
		
		TreeNode N7 = new TreeNode(7, null, null);
		TreeNode N6 = new TreeNode(6, null, null);
		TreeNode N5 = new TreeNode(5, N6, N7);
		TreeNode N4 = new TreeNode(4, null, null);
		TreeNode N3 = new TreeNode(3, null, null);
		TreeNode N2 = new TreeNode(2, N4, N5);
		TreeNode N1 = new TreeNode(1, N2, N3);
		
		N1.parent = null;
		N2.parent = N1;
		N3.parent = N1;
		N4.parent = N2;
		N5.parent = N2;
		N6.parent = N5;
		N7.parent = N5;
		
		inorder(N1);
		
		parseDFS(N1);
		System.out.println("-------------------");
		inorder(N1);
		System.out.println();
	}
	
	private static int parseDFS(TreeNode tree){
		if(tree == null)
			return -1;
		else{
			int lh = parseDFS(tree.left);
			int rh = parseDFS(tree.right);

			if(lh == rh){
				tree.height = lh + 1;
				return tree.height;
			}else if(lh > rh){
				leftLeftBalance(tree.left);
				return rh + 1;
			}else{
				tree = leftRightBalance(tree);
				return lh + 1;
			}
		}
	}
	
	
	private static TreeNode leftRightBalance(TreeNode tree){
		TreeNode p = tree.parent;
		TreeNode b = null;
		
		if(tree.right != null){
			if(tree.right.left != null){
				b = tree.right.left;
				tree.right.left = null;
			}
			tree.parent = tree.right;
		}
		
		if(p != null && tree.right != null){
			p.left = tree.right;
			tree.right.parent = p;
			p.left.left = tree;
		}
		
		if(b != null)
			tree.right = b;
		
		return tree.parent;
	}
	
	
	private static void leftLeftBalance(TreeNode tree){
		TreeNode p = tree.parent;
		TreeNode pp = null;
		TreeNode c = tree.right;
		
		if(p != null){
			pp = p.parent;
		}
		
		if(pp != null){
			pp.left = tree;
			tree.parent = pp;
		}
		
		if(p != null){
			tree.right = p;
			p.parent = tree.right;
			tree.right.left = c;
			c.parent = tree.right.left;
		}			
	}
	
	
	private static void inorder(TreeNode node){
		if(node == null)
			return;
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}
}
