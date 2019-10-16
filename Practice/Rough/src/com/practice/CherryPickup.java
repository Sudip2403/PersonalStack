package com.practice;

public class CherryPickup {

	public static void main(String[] args) {
		int[][] gp = new int[50][50];
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				gp[i][j] = 1;
			}
		}
		
		
		int[][] grid = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		System.out.println(new CherryPickup().cherryPickup(/*grid*/gp));
	}

	int[] x1 = { 0, 1 }, y1 = { 1, 0 }, x2 = { 0, -1 }, y2 = { -1, 0 };

	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		return d(grid, n, 0, 0, 0, new boolean[n][n], grid[0][0] == 1 ? 1 : 0);
	}

	
	int d(int[][] g, int n, int i, int j, int m, boolean[][] v, int c) {
		v[i][j] = true;
		if (i == n - 1 && j == n - 1) {
			v[i][j] = false;
			int y =  c /*+ u(g, n, i, j, new boolean[n][n], 0, 0)*/;
			System.out.println(y);
			return y;
		}
		for (int k = 0; k < 2; k++) {
			int a = i + x1[k];
			int b = j + y1[k];
			if (a < n && b < n && g[a][b] != -1 && !v[a][b]) {
				int r = g[a][b];
				g[a][b] = 0;
				m = Math.max(m, d(g, n, a, b, m, v, r + c));
				g[a][b] = r;
			}
		}
		v[i][j] = false;
		return m;
	}

	int u(int[][] g, int n, int i, int j, boolean[][] v, int c, int m) {
		v[i][j] = true;
		if (i == 0 && j == 0) {
			return c;
		}
		for (int k = 0; k < 2; k++) {
			int a = i + x2[k];
			int b = j + y2[k];
			if (a >= 0 && b >= 0 && g[a][b] != -1 && !v[a][b]) {
				int r = g[a][b];
				g[a][b] = 0;
				m = Math.max(m, u(g, n, a, b, v, r + c, m));
				g[a][b] = r;
			}
		}
		v[i][j] = false;
		return m;
	}

}
