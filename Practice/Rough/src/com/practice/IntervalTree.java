package com.practice;

public class IntervalTree {

	public static void main(String[] args) {
		IntervalTree it = new IntervalTree();
		it.create(new I(0, 10, 10));
		it.create(new I(2, 8, 8));
		it.create(new I(5, 15, 15));
		it.create(new I(12, 15, 15));
		it.create(new I(16, 20, 20));
		
		System.out.println(it.searchOverlap(it.intervalTree, new I(17, 20)));
		System.out.println(it.searchOverlap(it.intervalTree, new I(21, 22)));
	}

	I intervalTree = null;

	void create(I interval) {
		if (intervalTree == null) {
			I i = new I(interval.l, interval.r);
			i.m = interval.r;
			intervalTree = i;
		} else {
			add(intervalTree, interval);
			updateMax(intervalTree);
		}
	}

	boolean searchOverlap(I node, I i) {
		if (node != null && intersect(node.l, node.r, i.l, i.r))
			return true;
		if (node.lt == null && node.rt == null)
			return false;
		if (node.lt == null && node.rt != null)
			return searchOverlap(node.rt, i);
		if (i.l < node.lt.m)
			return searchOverlap(node.lt, i);
		else
			return searchOverlap(node.rt, i);
	}

	int updateMax(I i) {
		if (i == null)
			return 0;
		if (i.lt == null && i.rt == null)
			return i.m;
		i.m = Math.max(Math.max(updateMax(i.lt), updateMax(i.rt)), i.r);
		return i.m;
	}

	void add(I node, I i) {
		if (node == null)
			return;
		if (node.lt == null && i.l < node.l)
			node.lt = i;
		else if (node.rt == null && i.l > node.l)
			node.rt = i;

		if (i.l < node.l)
			add(node.lt, i);
		else
			add(node.rt, i);
	}

	boolean intersect(int p1, int p2, int q1, int q2) {
		if (q1 >= p1 && q1 <= p2)
			return true;
		if (p1 >= q1 && p1 <= q2)
			return true;
		return false;
	}

	static class I {
		int l, r, m;
		I lt, rt;

		public I(int l, int r) {
			this.l = l;
			this.r = r;
		}

		public I(int l, int r, int m) {
			this.l = l;
			this.r = r;
			this.m = m;
		}
	}
}
