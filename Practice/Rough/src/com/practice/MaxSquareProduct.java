package com.practice;

public class MaxSquareProduct {
/*
	public static void main(String[] args) {
		int[][] a = { { 12, 9, 0, 7, 6 }, { 6, 5, 2, 3, 0 }, { 1, 7, 2, 5, 18 }, { 0, 2, 2, 3, 7 },
				{ 2, 12, 13, 0, 85500 } };
		System.out.println(new MaxSquareProduct().maxSquareProduct(a));
	}

	long maxSquareProduct(int[][] a) {
		int n = a.length;
		long[][][] dp = new long[n][n][2];
		dp[0][0][0] = a[0][0];
		dp[0][0][1] = a[0][0];
		long max = Long.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			long p = min(a[0][i], dp[0][i - 1][0] * a[0][i], dp[0][i - 1][1] * a[0][i]),
					q = max(a[0][i], dp[0][i - 1][0] * a[0][i], dp[0][i - 1][1] * a[0][i]);
			dp[0][i][0] = p;
			dp[0][i][1] = q;

			p = min(a[i][0], dp[i - 1][0][0] * a[i][0], dp[i - 1][0][1] * a[i][0]);
			q = max(a[i][0], dp[i - 1][0][0] * a[i][0], dp[i - 1][0][1] * a[i][0]);
			dp[i][0][0] = p;
			dp[i][0][1] = q;

			max = max(max, dp[0][i][1], dp[i][0][1]);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				long p = min(dp[0][i - 1][0] * a[0][i], dp[0][i - 1][1] * a[0][i]),
						q = max(a[0][i], dp[0][i - 1][0] * a[0][i], dp[0][i - 1][1] * a[0][i]);
				
				
				dp[i][j][]
			}
		}

	}

	long min(long a, long b, long c) {
		return Math.min(a, Math.min(b, c));
	}

	long max(long a, long b, long c) {
		return Math.max(a, Math.max(b, c));
	}*/
}
