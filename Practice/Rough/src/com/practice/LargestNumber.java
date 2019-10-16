package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// Integer[] nums = { 121, 12 };
		// Integer[] nums = { 3,30,34,5,9 };
		Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		// Integer[] nums = { 10,2};
		// Integer[] nums = { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247
		// }; //"9609-938-824-8247-6973-5703-5607-4398-1399"
		System.out.println(new LargestNumber().largestNumber(nums));
	}

	public String largestNumber(Integer[] nums) {
		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				int p = (int) Math.pow(10, (int) Math.log10(a)), q = (int) Math.pow(10, (int) Math.log10(b)),
						n = a > 0 ? a / p : 0, m = b > 0 ? b / q : 0;// n = 0, m
																		// = 0;
				while (p > 0 && q > 0) {
					if (a / p > b / q)
						return -1;
					if (a / p < b / q)
						return 1;
					// n = a / p;
					// m = b / q;
					a %= p;
					b %= q;
					p /= 10;
					q /= 10;
				}
				if (p > 0) {
					if (a / p > n)
						return -1;
					else
						return 1;
				} else if (q > 0) {
					if (b / q > m)
						return 1;
					else
						return -1;
				}
				return 0;
			}
		});

		StringBuffer s = new StringBuffer();
		for (Integer i : nums) {
			s.append(i + "-");
		}
		return s.toString();
		// return new BigInteger(s.toString()).toString();
	}
}
