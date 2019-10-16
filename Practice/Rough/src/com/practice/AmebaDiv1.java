package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class AmebaDiv1 {

	public static void main(String[] args) {
		int[] X = { 854,250,934,1000,281,250,281,467,854,562,934,1000,854,500,562 };
		System.out.println(new AmebaDiv1().count(X));
	}

	public int count(int[] X) {
		int n = X.length;
		int[][] Y = new int[n][2];
		for (int i = 0; i < n; i++) {
			Y[i][0] = X[i];
			Y[i][1] = i;
		}
		Arrays.sort(Y, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int c = 0;
		for (int i = 0; i < n; i++) {
			int a = Y[i][1], s = Y[i][0];
			while (true) {
				s *= 2;
				int y = bs(Y, s);
				if (y < 0){
					if(a != Y[i][1])
						c++;
					break;
				}
				if (a > -1 && Y[y][1] > a)
					a = Y[y][1];
				else {
					if (a > -1 && Y[y][1] < a)
						c++;
					break;
				}
			}
		}
		return n - c;
	}

	private int bs(int[][] a, int k) {
		int l = 0, h = a.length - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m][0] == k)
				return m;
			if (k < a[m][0])
				h = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}
}