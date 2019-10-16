package com.practice;

import java.util.HashSet;

public class NotAnEasyTask {

	String notAnEasyTask(int[] a) {
		int n = a.length;
		HashSet[][] dp = new HashSet[n][n];
		for (int i = 0; i < n; i++) {
			HashSet<Integer> h = new HashSet<>();
			h.add(a[i]);
			dp[i][i] = h;
		}
		HashSet<Integer> hp = new HashSet<>();
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int j = k + i;
				if (j < n) {
					HashSet<Integer> h = new HashSet<>();
					HashSet<Integer> m = dp[i][j];
					for (int q : m) {
						h.add(q + a[j]);
						h.add(q * a[j]);
						if (a[j] != 0 && q % a[j] == 0)
							h.add(q / a[j]);
						if (q != 0 && a[i] % q == 0)
							h.add(q / a[j]);
					}
				}
			}
		}
		return "";
	}

}
