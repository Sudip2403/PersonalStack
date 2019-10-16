package com.practice;

import java.util.Arrays;

public class NotRepeated {

	public static void main(String[] args) {
		int[] n = { 1, 1, 1, 1 };
		System.out.println(new NotRepeated().notRepeated(n));
	}

	int notRepeated(int[] n) {
		Arrays.sort(n);
		int p = 1, r = 0, c = 1, m = n.length;
		while (p < m) {
			if (n[p] != n[p - 1]) {
				if (c == 1)
					r++;
				c = 1;
			}
			if (n[p] == n[p - 1])
				c++;
			p++;
		}
		return r + (n[m - 1] != n[m - 2] ? 1 : 0);
	}

}
