package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

	public static void main(String[] args) {
		Integer[][] p = { { 11, -7 }, { -19, -15 }, { -18, -18 }, { -5, -13 }, { 3, 17 } };
		System.out.println(new ClosestPair().closestPair(p));
	}

	double closestPair(Integer[][] p) {
		Arrays.sort(p, new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0] - o2[0];
			}
		});
		double m = Double.MAX_VALUE;
		for (int i = 1; i < p.length; i++)
			m = Math.min(m, Math.sqrt(Math.pow(p[i][0] - p[i - 1][0], 2) + Math.pow(p[i][1] - p[i - 1][1], 2)));

		Arrays.sort(p, new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int i = 1; i < p.length; i++)
			m = Math.min(m, Math.sqrt(Math.pow(p[i][0] - p[i - 1][0], 2) + Math.pow(p[i][1] - p[i - 1][1], 2)));
		return m;
	}

}
