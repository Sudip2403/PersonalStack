package com.practice;

import java.math.BigInteger;

public class LCDMinNumber {

	public static void main(String[] args) {
		int n = 237;// 6888888888888888888888888888888888
		System.out.println(new LCDMinNumber().lcdMinNumber(n));
	}

	String lcdMinNumber(int n) {
		String[][] dp = new String[n + 1][10];
		a(dp, n, 6, 0);
		a(dp, n, 2, 1);
		a(dp, n, 5, 2);
		a(dp, n, 4, 4);
		a(dp, n, 3, 7);
		a(dp, n, 7, 8);
		int[] b = new int[] { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < 10; j++) {
				String m = j == 0 ? dp[i][j] : c(dp[i][j], dp[i][j - 1]);
				if (i % b[j] == 0 && j > 0) {
					StringBuffer s = new StringBuffer();
					int k = i / b[j];
					for (int p = 0; p < k; p++)
						s.append(j);
					m = c(m, s.toString());
				}
				for (int k = 0; k < 10; k++) {
					if (i > b[j] && dp[i - b[j]][k] != null && dp[i - b[j]][k].charAt(0) != '0')
						m = c(m, dp[i - b[j]][k] + "" + j);
					else if (i - b[j] == b[k] && k > 0) {
						m = c(m, k + "" + j);
					}
				}
				dp[i][j] = m;
			}
		}
		return dp[n][9] + "";
	}

	String c(String a, String b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (new BigInteger(a).compareTo(new BigInteger(b)) < 0)
			return a;
		return b;
	}

	void a(String[][] dp, int N, int n, int m) {
		if (n > N)
			return;
		for (int i = m; i < 10; i++)
			dp[n][i] = m + "";
	}

}
