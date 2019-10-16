package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class SumOfIntervals {

	public static void main(String[] args) {
		/*int[][] intervals = { { 1025, 7020 }, { 453, 9070 }, { -2564, 3297 }, { -2972, 7986 }, { -8848, 5649 },
				{ -9646, 688 }, { -6783, 6056 }, { -7953, 7282 }, { -4071, 5801 }, { 6927, 9499 }, { 2176, 4554 },
				{ -3923, -2108 }, { 2649, 9533 }, { -7010, -5166 } };*/
		int[][] intervals = { { -3, -1 }, { -3, -1 } };
		System.out.println(sumIntervals(intervals));
	}

	public static int sumIntervals(int[][] intervals) {
		if (intervals == null)
			return 0;
		if (intervals.length == 0)
			return 0;

		Integer[][] i = new Integer[intervals.length][2];
		for (int k = 0; k < intervals.length; k++) {
			i[k][0] = intervals[k][0];
			i[k][1] = intervals[k][1];
		}
		Arrays.sort(i, new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				int t = o1[0].compareTo(o2[0]);
				if(t == 0)
					return o1[1].compareTo(o2[1]);
				return t;
			}
		});
		int r = i[0][1] - i[0][0];
		for (int k = 1; k < i.length; k++) {
			if (i[k][0] >= i[k - 1][0] && i[k][0] < i[k - 1][1] && i[k][1] > i[k - 1][1])
				r += i[k][1] - i[k - 1][1];
			else if (i[k][0] >= i[k - 1][1])
				r += i[k][1] - i[k][0];
		}
		return r;
	}
}
