package com.practice;

public class LongCityRoutes {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(new LongCityRoutes().LongCityRoutes(n));
	}

	int[] p = { 1, 0, -1, 0 }, q = { 0, 1, 0, -1 };

	long LongCityRoutes(int n) {
		return d(new boolean[4][n], 0, 1, n, false, 0, 1, "1,2")
				+ d(new boolean[4][n], 1, 0, n, false, 0, 1, "1," + (n + 1));
	}

	long d(boolean[][] v, int x, int y, int n, boolean e, long c, long l, String s) {
		if (x == 0 && y == 0 && e && l == n * 4) {
			//System.out.println(s);
			return c + 1;
		}
		if (x == 0 && y == 0) {
			return c;
		}
		v[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int a = x + p[i], b = y + q[i];
			if (a >= 0 && a < 4 && b >= 0 && b < n && !v[a][b]) {
				if (a == 3 && b == n - 1)
					c = d(v, a, b, n, true, c, l + 1, s + "," + (a * n + b + 1));
				else
					c = d(v, a, b, n, e, c, l + 1, s + "," + (a * n + b + 1));
			}
		}
		v[x][y] = false;
		return c;
	}
}
