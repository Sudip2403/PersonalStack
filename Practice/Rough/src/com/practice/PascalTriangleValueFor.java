package com.practice;

public class PascalTriangleValueFor {

	public static void main(String[] args) {
		int r = 20, p = 40;
		int[][] d = new int[r + 1][p + 1];
		System.out.println(new PascalTriangleValueFor().PascalTriangleValueFor(r, p, d));
	}

	int PascalTriangleValueFor(int r, int p, int[][] d) {
		if (p == 0 || p == r || r == 0)
			return 1;
		//if (d[r][p] != 0)
		//	return d[r][p];
		int k = PascalTriangleValueFor(r - 1, p - 1, d) + PascalTriangleValueFor(r - 1, p, d);
		d[r][p] = k;
		return k;
	}

}
