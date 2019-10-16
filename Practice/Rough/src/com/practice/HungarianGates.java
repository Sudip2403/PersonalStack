package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HungarianGates {

	public static void main(String[] args) {
		// int[][] table = { { 1, 2, 3 }, { 4, 6, 7 }, { 5, 8, 9 } };
		// int[][] table = { { 3, 11, 15, 1 }, { 12, 4, 6, 7 }, { 13, 10, 16, 2
		// }, { 5, 14, 9, 8 } };
		int[][] table = { { 7, 22, 21, 2, 24 }, { 9, 7, 3, 18, 2 }, { 23, 0, 6, 15, 18 }, { 4, 20, 19, 10, 23 },
				{ 24, 9, 14, 2, 13 } };
		int p = 5;
		System.out.println(new HungarianGates().gates(p, table));
	}

	int[][] table, tableOriginalValue;
	int n, m;
	boolean[] verticalRun, horizontalRun;

	int gates(int p, int[][] table) {
		n = p;
		m = p;
		tableOriginalValue = new int[n][];
		for (int i = 0; i < n; i++)
			tableOriginalValue[i] = Arrays.copyOf(table[i], m);
		this.table = table;
		verticalRun = new boolean[n];
		horizontalRun = new boolean[m];

		print();
		initialRowZeros();
		initialColumnZeros();
		print();
		int v = optimalLines();
		if (v == n) {
			return allocateTask();
		}
		while (v < n) {
			findOptimal();
			verticalRun = new boolean[n];
			horizontalRun = new boolean[m];
			v = optimalLines();
			print();
		}
		return allocateTask();
	}

	void initialRowZeros() {
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++)
				min = Math.min(min, table[i][j]);
			for (int j = 0; j < m; j++)
				table[i][j] -= min;
		}
	}

	void initialColumnZeros() {
		for (int i = 0; i < m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++)
				min = Math.min(min, table[j][i]);
			for (int j = 0; j < n; j++)
				table[j][i] -= min;
		}
	}

	int optimalLines() {
		PriorityQueue<P> p = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (table[i][j] == 0)
					p.add(new P(i, j));
			}
		}
		int lines = 0;
		while (!p.isEmpty()) {
			P q = p.poll();
			if (horizontalRun[q.i] || verticalRun[q.j])
				continue;

			if (q.r_zeros > q.c_zeros) {
				horizontalRun[q.i] = true;
				lines++;
				if (!p.isEmpty() && q.c_zeros > Math.max(p.peek().c_zeros, p.peek().r_zeros)) {
					verticalRun[q.j] = true;
					lines++;
				}
			} else {
				verticalRun[q.j] = true;
				lines++;
				if (!p.isEmpty() && q.r_zeros > Math.max(p.peek().c_zeros, p.peek().r_zeros)) {
					horizontalRun[q.i] = true;
					lines++;
				}
			}
		}
		return lines;
	}

	void findOptimal() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (horizontalRun[i])
				continue;
			for (int j = 0; j < m; j++) {
				if (verticalRun[j])
					continue;
				min = Math.min(min, table[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			if (horizontalRun[i])
				continue;
			for (int j = 0; j < m; j++) {
				table[i][j] -= min;
			}
		}
		for (int i = 0; i < m; i++) {
			if (!verticalRun[i])
				continue;
			for (int j = 0; j < n; j++)
				table[j][i] += min;
		}
	}

	@SuppressWarnings("unchecked")
	int allocateTask() {
		ArrayList<Integer>[] d = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				if (table[i][j] == 0 || verticalRun[j] || horizontalRun[i])
					a.add(j);
			}
			d[i] = a;
		}
		return dfs(d, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, new boolean[m], "");
	}

	int dfs(ArrayList<Integer>[] d, int i, int min, int dfsmax, boolean[] jobs, String s) {
		if (i == n){
			System.out.println(s + " min:" + Math.min(min, dfsmax) + " dfsmax:" + dfsmax);
			return Math.min(min, dfsmax);
		}
		ArrayList<Integer> a = d[i];
		for (Integer k : a) {
			if (!jobs[k]) {
				jobs[k] = true;
				min = dfs(d, i + 1, min, Math.max(dfsmax, tableOriginalValue[i][k]), jobs, s + ", " + k);
				jobs[k] = false;
			}
		}
		return min;
	}

	class P implements Comparable<P> {
		int i, j, r_zeros, c_zeros;

		public P(int i, int j) {
			super();
			this.i = i;
			this.j = j;
			for (int p = 0; p < m; p++) {
				if (table[i][p] == 0)
					this.r_zeros++;
			}
			for (int p = 0; p < n; p++) {
				if (table[p][j] == 0)
					this.c_zeros++;
			}
		}

		@Override
		public int compareTo(P p) {
			if (c_zeros + r_zeros - p.c_zeros - p.r_zeros != 0)
				return c_zeros + r_zeros - p.c_zeros - p.r_zeros;
			if (i < p.i)
				return -1;
			if (i > p.i)
				return 1;
			if (j < p.j)
				return -1;
			if (j > p.j)
				return 1;
			return 1;
		}
	}

	void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print((table[i][j] / 10 == 0 ? " " : "") + table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print((horizontalRun[i] || verticalRun[j]) ? " * "
						: ((table[i][j] / 10 == 0 ? " " : "") + table[i][j] + " "));
			}
			System.out.println();
		}
		System.out.println("===========================================");
	}

}
