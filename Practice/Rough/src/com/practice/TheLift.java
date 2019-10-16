package com.practice;

import java.util.ArrayList;
import java.util.List;

public class TheLift {

	public static void main(String[] args) {
		int[][] queues = { new int[0], // G
			      new int[]{3}, // 1
			      new int[]{4}, // 2
			      new int[0], // 3
			      new int[]{5}, // 4
			      new int[0], // 5
			      new int[0], // 6
		};
		int capacity = 5;
		int[] r = theLift(queues, capacity);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}

	public static int[] theLift(final int[][] queues, final int capacity) {
		List<Integer> r = new ArrayList<>();
		r.add(0);
		List<Integer> q = new ArrayList<>();
		int x = 0;
		for (int i = 0; i < queues.length; i++)
			x += queues[i].length;

		if (queues[0].length > 0) {
			for (int i = 0; i < queues[0].length; i++)
				q.add(queues[0][i]);
		}

		int f = 0, u = 1;
		while (x > 0) {
			if (f == queues.length) {
				u = 0;
				f = queues.length - 1;
			} else if (f == -1) {
				u = 1;
				f = 0;
			}

			if (u == 1) {
				int p = -1;
				if (!q.isEmpty()) {
					boolean b = false;
					List<Integer> qq = new ArrayList<>();
					for (int fl : q) {
						if (fl == f) {
							x--;
							b = true;
						} else
							qq.add(fl);
					}
					q = new ArrayList<>(qq);
					if (b) {
						p = f;
						r.add(f);
					}
				}
				if (queues[f].length > 0) {
					boolean b = false;
					for (int i = 0; i < queues[f].length; i++) {
						if (queues[f][i] > f && q.size() <= capacity) {
							q.add(queues[f][i]);
							queues[f][i] = 0;
							b = true;
						}
					}
					if (p == -1 && b)
						r.add(f);
				}
				f++;
			} else {
				int p = -1;
				if (!q.isEmpty()) {
					boolean b = false;
					List<Integer> qq = new ArrayList<>();
					for (int fl : q) {
						if (fl == f) {
							x--;
							b = true;
						} else
							qq.add(fl);
					}
					q = new ArrayList<>(qq);
					if (b) {
						p = f;
						r.add(f);
					}
				}
				if (queues[f].length > 0) {
					boolean b = false;
					for (int i = 0; i < queues[f].length; i++) {
						if (queues[f][i] < f && q.size() <= capacity) {
							q.add(queues[f][i]);
							queues[f][i] = 0;
							b = true;
						}
					}
					if (p == -1 && b)
						r.add(f);
				}
				f--;
			}
		}
		if (r.get(r.size() - 1) != 0)
			r.add(0);
		int[] rr = new int[r.size()];
		for (int i = 0; i < r.size(); i++)
			rr[i] = r.get(i);

		return rr;
	}

}
