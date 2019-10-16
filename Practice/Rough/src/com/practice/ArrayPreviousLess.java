package com.practice;

public class ArrayPreviousLess {

	int[] arrayPreviousLess(int[] a) {
		int n = a.length;
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = -1;
			for (int j = i - 1; j > -1; j--) {
				if (a[j] < a[i]) {
					r[i] = a[j];
					break;
				}
			}
		}
		return r;
	}

}
