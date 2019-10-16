package com.practice;

public class CheckForBalancedTree {

	public static void main(String[] args) {
		BTree N9 = new BTree(9, null, null);
		BTree N8 = new BTree(8, null, null);
		BTree N7 = new BTree(7, null, null);
		BTree N6 = new BTree(6, null, null);
		BTree N5 = new BTree(5, N6, N9);
		BTree N4 = new BTree(4, N7, N8);
		BTree N3 = new BTree(3, N5, null);
		BTree N2 = new BTree(2, null, null);
		BTree N1 = new BTree(1, N3, N4);
		BTree N0 = new BTree(0, N1, N2);

		System.out.println(isBalanced(N0) != -1);

		System.out.println(lowestCommonAncestor1(N0, N5, N4).value);

		BTree N10 = new BTree(0, N1, N2);

	}

	static BTree greatestNoLessThanOrEqual(BTree node, int n) {
		if (node == null)
			return node;
		if (node.value == n)
			return node;
		if (node.left != null && node.left.value <= n && node.value > n)
			return node.left;
		if (n < node.value)
			return greatestNoLessThanOrEqual(node.left, n);
		return greatestNoLessThanOrEqual(node.right, n);

		/*
		 * int val = -1; while(root != null) { if(root.data > n) { root =
		 * root.left; } else { val = root.data; root = root.right; } } return
		 * val;
		 */
	}

	static BTree lowestCommonAncestor1(BTree root, BTree p, BTree q) {
		if (root == null || root == p || root == q)
			return root;
		BTree left = lowestCommonAncestor1(root.left, p, q);
		BTree right = lowestCommonAncestor1(root.right, p, q);
		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		if (right != null)
			return right;
		return null;
	}

	public static BTree lowestCommonAncestor(BTree root, BTree p, BTree q) {
		if (root == null || root == p || root == q)
			return root;
		BTree left = lowestCommonAncestor(root.left, p, q);
		BTree right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	static int isBalanced(BTree node) {
		if (node == null)
			return 0;

		int leftHeight = isBalanced(node.left);
		int rightHeight = isBalanced(node.right);

		if (leftHeight == -1 || rightHeight == -1)
			return -1;

		if (Math.abs(rightHeight - leftHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;

	}

	static class BTree {
		int value;
		BTree left;
		BTree right;

		public BTree(int value, BTree left, BTree right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
