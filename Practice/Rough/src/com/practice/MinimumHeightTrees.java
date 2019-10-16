package com.practice;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[][] adjm = new int[n][n];
		for (int i = 0; i < edges.length; i++) {
			adjm[edges[i][0]][edges[i][1]] = 1;
			adjm[edges[i][1]][edges[i][0]] = 1;
		}
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> b = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (adjm[i][j] == 1)
					b.add(j);
			}
			a.add(i, b);
		}
		int m = 10000;
		List<Integer> k = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] g = { 0 };
			dfs(i, a, new boolean[n], 0, g);
			if (g[0] < m) {
				k = new ArrayList<>();
				k.add(i);
				m = g[0];
			} else if (m == g[0]) {
				k.add(i);
			}
		}
		return k;
	}

	private int dfs(int n, List<List<Integer>> adjm, boolean[] v, int c, int[] g) {
		v[n] = true;
		List<Integer> y = adjm.get(n);
		for (Integer i : y) {
			if (!v[i]) {
				dfs(i, adjm, v, c + 1, g);
			}
		}
		g[0] = Math.max(c, g[0]);
		return c;
	}

}
