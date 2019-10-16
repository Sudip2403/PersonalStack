package com.practice;

public class DiceSums {

	public static void main(String[] args) {
		int n = 5, s = 10;
		System.out.println(new DiceSums().diceSums(n, s));
		// System.out.println(new DiceSums().diceSums1(n, s));
		System.out.println(new DiceSums().diceSums2(n, s));
	}

	long diceSums2(int n, int x) {
		int m = 6;
		long[][] table = new long[n + 1][x + 1];
		for (int j = 1; j <= m && j <= x; j++)
			table[1][j] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= x; j++) {
				for (int k = 1; k < j && k <= m; k++)
					table[i][j] += table[i - 1][j - k];
			}
		}
		return table[n][x];
	}

	long diceSums1(int n, int s) {
		int[][][] dp = new int[s + 1][7][n + 1];
		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= 6; j++) {
				for (int k = 1; k <= n; k++) {
					if (k * j == i)
						dp[i][j][k] += 1;
					else if (k * j > i)
						break;
					else {
						for (int p = 1; p < 7; p++) {
							if (dp[i - j * k][p][n - k] > 0)
								dp[i][j][k] += dp[i - j * k][p][n - k];
						}
					}
				}
			}
		}
		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= 6; j++) {
				for (int k = 1; k <= n; k++) {
					System.out.print(dp[i][j][k] + " ");
				}
				System.out.print("  ");
			}
			System.out.println();
		}

		long r = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == s)
					continue;
				r += dp[s][i][j];
			}
		}
		return r;
	}

	long c() {
		return 0;
	}

	long diceSums(int n, int s) {
		return f(s, 0, 0, 0, n, "");
	}

	long f(int s, int d, long c, int p, int n, String t) {
		if (d == s && p == n) {
			System.out.println(t);
			return c + 1;
		}
		if (d > s || p > n)
			return c;
		for (int i = 1; i <= 6; i++)
			c = f(s, d + i, c, p + 1, n, t + i);
		return c;
	}

}
