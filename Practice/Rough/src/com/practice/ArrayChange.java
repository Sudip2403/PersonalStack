package com.practice;

import java.util.Arrays;

public class ArrayChange {

	public static void main(String[] args) {
		int[] a = { -1000, 0, -2, 0 };
		System.out.println(new ArrayChange().arrayChange(a));
	}

	int arrayChange(int[] a) {
		int n = a.length, c = 0;
		//Arrays.sort(a);
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1])
				continue;
			c += Math.abs(a[i] - a[i - 1]) + 1;
			a[i] = a[i - 1] + 1;
		}
		return c;
	}

}
