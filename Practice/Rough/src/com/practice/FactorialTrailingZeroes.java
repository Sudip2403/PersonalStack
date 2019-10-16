package com.practice;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		int n = 75;
		System.out.println(new FactorialTrailingZeroes().factorialTrailingZeroes(n));
	}

	int factorialTrailingZeroes(int n) {
		int[] t = new int[n + 1];
		int[] f = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1];
			t[i] = t[i - 1];
			int j = i;
			while (j % 5 == 0) {
				f[i] += 1;
				j /= 5;
			}
			while (j % 2 == 0) {
				t[i] += 1;
				j /= 2;
			}
		}
		return Math.min(t[n], f[n]);
	}

}
