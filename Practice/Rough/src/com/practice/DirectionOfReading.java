package com.practice;

public class DirectionOfReading {

	public static void main(String[] args) {
		int[] n = { 12, 345, 67, 5 };
		int[] r = new DirectionOfReading().directionOfReading(n);
		for (int i : r) {
			System.out.print(i + " ");
		}
	}

	int[] directionOfReading(int[] n) {
		int m = n.length;
		int[] y = new int[m], r = new int[m];
		for (int i = 0; i < m; i++)
			y[i] = m - String.valueOf(n[i]).length();
		for (int i = 0; i < m; i++) {
			int p = 0;
			while (p < m) {
				r[p] = Integer.parseInt(
						String.valueOf(r[p]) + (y[i] <= 0 ? String.valueOf(n[i]).charAt(Math.abs(y[i])) : "0"));
				y[i]--;
				p++;
			}
		}
		return r;
	}

}
