package com.practice;

public class UpdateInspaceBSTToMaxValues {

	int updateValues(TM node, int r) {
		if (node == null)
			return 0;
		if (node.right == null)
			return r;
		if (node.left == null)
			return r;

		int t = updateValues(node.right, r);
		node.v += t;
		updateValues(node.left, node.v);
		return node.v;
	}
}

class TM {
	int v;
	TM left;
	TM right;

	public TM(int v, TM left, TM right) {
		super();
		this.v = v;
		this.left = left;
		this.right = right;
	}

}
