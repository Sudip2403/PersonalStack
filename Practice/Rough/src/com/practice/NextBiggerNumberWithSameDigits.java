package com.practice;

import java.util.Arrays;

public class NextBiggerNumberWithSameDigits {

	public static void main(String[] args) {
		long n = 2045181183;
		System.out.println(nextBiggerNumber(n));
	}

	public static long nextBiggerNumber(long n) {
		char[] c = String.valueOf(n).toCharArray();
		long r = Long.MAX_VALUE;
		for (int i = c.length - 1; i >= 0; i--) {
			boolean f = false;
			c = String.valueOf(n).toCharArray();
			for (int j = i - 1; j >= 0; j--) {
				if (c[i] > c[j]) {
					char t = c[i];
					c[i] = c[j];
					c[j] = t;
					Arrays.sort(c, j + 1, c.length);
					f = true;
					break;
				}
			}
			if (f)
				r = Math.min(r, Long.parseLong(String.valueOf(c)));
		}
		return r == Long.MAX_VALUE ? -1 : r;
	}

}
