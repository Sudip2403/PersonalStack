package com.practice;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		// int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] a = { -2, -3, 5 };
		System.out.println(new KadanesAlgorithm().largestSum(a));
	}

	int largestSum(int[] a) {
		int n = a.length, max_sum = a[0];
		int[] dp = new int[n];
		dp[0] = a[0];
		for (int i = 1; i < n; i++) {
			if (dp[i - 1] + a[i] > a[i]) {
				dp[i] = dp[i - 1] + a[i];
			} else {
				dp[i] = a[i];
			}
			max_sum = Math.max(max_sum, dp[i]);
		}
		return max_sum;
	}
}
