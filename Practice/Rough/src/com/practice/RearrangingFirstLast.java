package com.practice;

public class RearrangingFirstLast {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9, 10, 8, 6, 4, 2 };
		int[] r = new RearrangingFirstLast().rearrangFirstLast(a);
		for (int i : r) {
			System.out.print(i + " ");
		}
	}

	int[] rearrangFirstLast(int[] a) {
		int n = a.length, p = n - 1, i = 1, j = 1;
		if (n <= 1)
			return a;
		int[] r = new int[n];
		r[0] = a[0];
		while (i < n) {
			r[i] = a[p--];
			if (i + 1 < n)
				r[i + 1] = a[j];
			i += 2;
			j += 1;
		}
		return r;
	}

}
