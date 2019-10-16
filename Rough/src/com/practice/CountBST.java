package com.practice;

public class CountBST {

	public static void main(String[] args) {
		countTreeDP(3);
		//System.out.println("Total trees - " + totalTree(3));
	}
	public static void countTreeDP(int n) {
		long a[][] = new long[n + 2][n + 1];
		for (int i = 0; i < n + 2; i++) {
			a[i][0] = 1L;
		}

		long sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum = 0;
			for (int j = 1; j <= i; j++) {
				a[j][i] = a[n + 1][i - j] * a[n + 1][j - 1];
				sum += a[j][i];
			}
			a[n + 1][i] = sum;
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.println("Trees possible with " + i + " unique elements "
					+ a[n + 1][i]);
		}
	}
	
	
	public static int totalTree(int n) {
		if (n == 1 || n == 0)
			return 1;
		else {
			int left = 0;
			int right = 0;
			int sum = 0;
			for (int k = 1; k <= n; k++) {
				left = totalTree(k - 1);
				right = totalTree(n - k);
				sum = sum + (left * right);
			}
			return sum;
		}
	}
}
