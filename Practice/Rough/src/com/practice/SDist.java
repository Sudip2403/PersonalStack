package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SDist {

	public static void main(String[] args) {
		String s = "fpdywbjovzlqpczojwix";
		String c = "j";
		System.out.println(new SDist().sDist(s, c));
	}

	long sDist(String s, String c) {
		if (c.isEmpty())
			return -1;

		char[] a = s.toCharArray();
		int n = a.length;
		List<Integer> i = new ArrayList<>();
		for (int k = 0; k < n; k++) {
			if (a[k] == c.charAt(0))
				i.add(k);
		}
		if (i.isEmpty())
			return -1;
		Integer[] u = i.toArray(new Integer[i.size()]);
		Arrays.sort(u);
		long r = 0;
		for (int k = 0; k < n; k++) {
			int q = Arrays.binarySearch(u, k), p = n;
			if (q < 0) {
				int ad = Math.abs(q + 1);
				if (ad >= u.length)
					p = Math.min(p, Math.abs(u[ad - 1] - k));
				if (ad < u.length && ad > 0) {
					p = Math.min(p, Math.abs(u[ad - 1] - k));
					p = Math.min(p, Math.abs(u[ad] - k));
				}
				if (ad == 0)
					p = Math.min(p, Math.abs(u[0] - k));
				r += p;
			}
		}
		return r;
	}

}
