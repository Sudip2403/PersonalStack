package com.practice;

import java.util.Arrays;

public class MaximumSubsetProduct {

	public static void main(String[] args) {
		int[] a = { 1000000000, -1000000000 };
		System.out.println(new MaximumSubsetProduct().maximumSubsetProduct(a));
	}

	int maximumSubsetProduct(int[] a) {
		int n = a.length;
		Arrays.sort(a);
		int p = -1;
		long q = 1, d = 1;
		boolean z = false;
		for (int i = 0; i < n; i++) {
			if (a[i] < 0)
				p = i;
			if (a[i] == 0)
				z = true;
			q *= a[i];
		}
		if (z)
			return 0;
		if (p == -1 || p == n - 1)
			return 1;

		int w = (p % 2) != 0 ? p : p - 1;
		for (int i = 0; i <= w; i++)
			d *= a[i];
		for (int i = p + 1; i < n; i++)
			d *= a[i];
		return (int) (q / d);
	}

}
