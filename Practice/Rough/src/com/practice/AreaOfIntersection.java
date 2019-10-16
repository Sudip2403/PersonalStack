package com.practice;

public class AreaOfIntersection {

	public static void main(String[] args) {
		int[] a = { 3, 0, -1 }, b = { 5, 3, 0 };
		System.out.println(new AreaOfIntersection().areaOfIntersection(a, b));
	}

	int f = 1000;

	int areaOfIntersection(int[] a, int[] b) {
		int[][] g = new int[f][f];
		int m = Math.abs(Math.min(Math.min(a[1] - a[0] - 1, b[1] - b[0] - 1), 0)),
				n = Math.abs(Math.min(Math.min(a[2] - a[0] - 1, b[2] - b[0] - 1), 0));
		return f(g, a[0], m + a[1], n + a[2]) + f(g, b[0], m + b[1], n + b[2]);
	}

	int f(int[][] g, int k, int x, int y) {
		int o = 0;
		int a = x - k + 1, b = x + k, c = y, d = y;
		while (k > 0) {
			for (int i = a; i < b; i++) {
				if (g[i][c] != 0)
					o++;
				else
					g[i][c] = 1;
				if (g[i][d] != 0 && c != d)
					o++;
				else
					g[i][d] = 1;
			}
			a += 1;
			b -= 1;
			k -= 1;
			c -= 1;
			d += 1;
		}
		return o;
	}

}
