package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PathFinderTheAlpinist {

	public static void main(String[] args) {
		String maze = // "000\n" + "000\n" + "000";
				"207075\n" + "207345\n" + "354295\n" + "599546\n" + "406794\n" + "868932";
		System.out.println(pathFinder1(maze));
	}

	static int[] x = { 1, 0, -1, 0 };
	static int[] y = { 0, 1, 0, -1 };

	static int pathFinder1(String maze) {
		String[] sp = maze.split("\n");
		int[][] a = new int[sp.length][sp[0].length()];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = Integer.parseInt(String.valueOf(sp[i].charAt(j)));
			}
		}

		int n = a.length, m = a[0].length, min = Integer.MAX_VALUE;
		Map<Integer, Boolean> v = new HashMap<>();
		v.put(0, true);
		for (int i = 1; i < n * m; i++)
			v.put(i, false);
		Stack<T> stack = new Stack<>();
		stack.add(new T(0, 0, 0, v));
		while (!stack.isEmpty()) {
			Stack<T> stackIn = new Stack<>();
			while (!stack.isEmpty()) {
				T t = stack.pop();
				if (t.x == n - 1 && t.y == n - 1) {
					min = Math.min(min, t.p);
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int w = t.x + x[i], u = t.y + y[i], k = w * n + u;
					if (w >= 0 && u >= 0 && w < n && u < m && !t.v.get(k)) {
						Map<Integer, Boolean> kk = new HashMap<>(t.v);
						kk.put(k, true);
						stackIn.push(new T(w, u, t.p + Math.abs(a[t.x][t.y] - a[w][u]), kk));
					}
				}
			}
			if (!stackIn.isEmpty())
				stack.addAll(stackIn);
		}
		return min;
	}

	static class T {
		int x, y, p;
		Map<Integer, Boolean> v;

		public T(int x, int y, int p, Map<Integer, Boolean> v) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.v = v;
			this.v = v;
		}
	}

	static void pathFinder(int[][] a, boolean[][] v, int p, int q, int n, int m, int[] r, String[] k, int s,
			String pa) {
		if (p == n - 1 && q == m - 1) {
			if (r[0] > s)
				k[0] = pa;
			r[0] = Math.min(s, r[0]);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int w = p + x[i], u = q + y[i];
			if (w >= 0 && u >= 0 && w < n && u < m && !v[w][u]) {
				v[w][u] = true;
				pathFinder(a, v, w, u, n, m, r, k, s + Math.abs(a[p][q] - a[w][u]),
						pa + (i == 0 ? "D" : i == 1 ? "R" : i == 2 ? "U" : "L"));
				v[w][u] = false;
			}
		}
	}

	static int pathFinder(String maze) {
		String[] sp = maze.split("\n");
		int[][] a = new int[sp.length][sp[0].length()];
		int[][] d = new int[sp.length][sp[0].length()];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = Integer.parseInt(String.valueOf(sp[i].charAt(j)));
			}
		}

		for (int i = 1; i < a.length; i++)
			d[i][0] = Math.abs(a[i][0] - a[i - 1][0]) + d[i - 1][0];
		for (int i = 1; i < a[0].length; i++)
			d[0][i] = Math.abs(a[0][i] - a[0][i - 1]) + d[0][i - 1];

		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[0].length; j++) {
				d[i][j] = Math.min(Math.abs(a[i][j] - a[i - 1][j]) + d[i - 1][j],
						Math.abs(a[i][j] - a[i][j - 1]) + d[i][j - 1]);
			}
		}
		// test
		int[] r = { Integer.MAX_VALUE };
		String[] k = { "" };
		pathFinder(a, new boolean[a.length][a[0].length], 0, 0, a.length, a[0].length, r, k, 0, "");
		System.out.println("------->>>>>" + r[0] + "  " + k[0]);
		// test

		return d[a.length - 1][a[0].length - 1];
	}
}
