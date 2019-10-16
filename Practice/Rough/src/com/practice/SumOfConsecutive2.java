package com.practice;

public class SumOfConsecutive2 {

	public static void main(String[] args) {
		int n = 9;
		// System.out.println(new SumOfConsecutive2().isSumOfConsecutive2(n));
		System.out.println(new SumOfConsecutive2().f(n, n / 2, n - n / 2));
	}

	int f(int n, int a, int b) {
		if (a == 0)
			return 0;
		if (Math.abs(a - b) == 1)
			return 1 + f(a, a / 2, a - a / 2) + f(b, b / 2, b - b / 2);
		return 0;
	}

	int isSumOfConsecutive2(int n) {
		int[] d = new int[n + 1];
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				if (i - 2 * j == 1)
					d[i]++;
				// d[i] += d[i - j] + d[j];
			}
		}
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + ", ");
		}
		System.out.println();
		return d[n];
	}

}
