package com.practice;

import java.util.Arrays;

public class MaxMinCombination {

	public static void main(String[] args) {
		int m = 10000002;
		int[] r = new MaxMinCombination().MaxMinCombination(m);
		System.out.println(r[0] + ", " + r[1]);
	}

	int[] MaxMinCombination(int m) {
		int n = String.valueOf(m).length(), i = 0;
		int[] a = new int[n];
		while (m > 0) {
			a[i++] = m % 10;
			m /= 10;
		}
		Arrays.sort(a);
		String p = "", q = "";
		for (int k = 0; k < n; k++) {
			q += a[n - 1 - k];
			p += a[k];
		}
		i = 0;
		while (i < n && p.charAt(i) == '0')
			i++;
		if (i < n)
			p = p.charAt(i) + p.substring(0, i) + p.substring(i + 1, n);
		return new int[] { Integer.parseInt(p), Integer.parseInt(q) };
	}

}
