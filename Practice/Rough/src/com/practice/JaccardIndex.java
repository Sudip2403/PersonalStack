package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JaccardIndex {

	public static void main(String[] args) {
		int[][] s = { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 5, 5, 5, 5, 6 } };
		int[] r = new JaccardIndex().jaccardIndex(s);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}

	int[] jaccardIndex(int[][] s) {
		int n = s.length, i = 0;
		int[] r = new int[n];
		while (i < n) {
			r[i] = f(s[i], i + 1 == n ? s[0] : s[i + 1]);
			i++;
		}
		return n > 2 ? r : Arrays.copyOfRange(r, 0, 1);
	}

	int f(int[] a, int[] b) {
		int i = 0, j = 0, n = a.length, m = b.length, r = 0;
		Set<Integer> t = new HashSet<>();
		while (i < n && j < m) {
			while (i < n && j < m && a[i] < b[j]) {
				t.add(a[i]);
				i++;
			}
			while (i < n && j < m && a[i] > b[j]) {
				t.add(b[j]);
				j++;
			}
			if (i < n && j < m) {
				t.add(a[i]);
				r++;
				i++;
				j++;
			}
		}
		while (i < n)
			t.add(a[i++]);
		while (j < m)
			t.add(b[j++]);
		return r / t.size() * 100;
	}
}
