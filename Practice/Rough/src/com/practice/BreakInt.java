package com.practice;

public class BreakInt {

	public static void main(String[] args) {
		int n = 9;
		System.out.println(new BreakInt().breakInt(n));
	}

	int breakInt(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int m = 0;
			for (int j = 1; j <= (i + 1) / 2; j++) {
				m = Math.max(m, dp[j] * dp[i - j]);
				m = Math.max(m, j * (i - j));
				m = Math.max(m, dp[j] * (i - j));
				m = Math.max(m, j * dp[i - j]);
			}
			dp[i] = m;
		}
		return dp[n];
	}

}
