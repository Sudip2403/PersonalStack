package com.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CountInversionsNaive {

	public static void main(String[] args) {
		int[] a = {20, 5, 19, 10, 8, 8, 8, 23, 10, -19, 1, 17, -22, -9, -2, -4, -21, -23, -16, 23, -9, 0, 22, -5};//{1, 3, 2, 0};//{ 1, 4, 10, 4, 2 };
		System.out.println(new CountInversionsNaive().countInversionsEx(a));
			
	}

	long countInversionsEx(int[] a) {
		int n = a.length;
		long r = 0;
		ArrayList<Integer> b = new ArrayList<>();
		b.add(a[0]);
		Map<Integer, Integer> m = new HashMap<>();
		m.put(a[0], 1);
		for (int i = 1; i < n; i++) {
			int t = bs(b, a[i]);//Collections.binarySearch(b, a[i]);
			int k = (m.get(a[i]) == null) ? 0 : m.get(a[i]);
			r += (t < 0 ? b.size() - Math.abs(t + 1) : (b.size() - t - k));
			b.add(t < 0 ? (-1 * t - 1) : t, a[i]);
			m.put(a[i], k + 1);
		}
		return r;
	}

	int bs(ArrayList<Integer> b, int k) {
		int l = 0, h = b.size() - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			int f = b.get(m);
			if (f == k && (m == 0 || (m > 0 && b.get(m - 1) < k)))
				return m;
			if (f > k)
				h = m - 1;
			else
				l = m + 1;
		}
		return -1 * l - 1;
	}
	
	int countInversionsNaive(int[] a) {
		int n = a.length, r = 0;
		ArrayList<Integer> b = new ArrayList<>();
		b.add(a[0]);
		for (int i = 1; i < n; i++) {
			int t = Collections.binarySearch(b, a[i]);
			r += (t < 0 ? b.size() - Math.abs(t + 1) : (b.size() - Math.abs(t) - 1));
			b.add(t < 0 ? (-1 * t - 1) : t, a[i]);
		}

		return r;
	}

}
