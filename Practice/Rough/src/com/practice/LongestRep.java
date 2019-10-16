package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestRep {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		System.out.println(new LongestRep().longestRep(s, k));
	}

	int longestRep(String s, int k) {
		char[] c = s.toCharArray();
		int n = c.length, f = 0;
		if (n == 0)
			return 0;
		char p = c[0];
		List<T> l = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (c[i] != p) {
				l.add(new T(f, i - 1));
				f = i;
				p = c[i];
			}
		}
		l.add(new T(f, n - 1));
		Collections.sort(l);
		if (k == 0)
			return l.get(0).e - l.get(0).s + 1;
		int m = 0;
		for (T t : l) {
			int i = t.s > 0 ? t.s - 1 : 0, j = t.e < n - 1 ? t.e + 1 : n - 1, h = k;
			if (i > 0) {
				char st = s.charAt(t.s);
				while (i >= 0 && h > 0) {
					if (c[i] != st)
						h--;
					i--;
				}
				while (i >= 0 && c[i] == st)
					i--;
			}
			if (j < n) {
				char en = s.charAt(t.e);
				h = k;
				while (j < n && h > 0) {
					if (c[j] != en)
						h--;
					j++;
				}
				while (j < n && c[j] == en)
					j++;
			}
			i = i < 0 ? 0 : i + 1;
			j = j >= n ? n - 1 : j - 1;
			if (t.s > 0 && t.e < n - 1 && c[t.s - 1] == c[t.e + 1])
				m = Math.max(m, Math.min(j - i, t.e - t.s + k) + 1);
			else {
				m = Math.max(m, t.e - i + 1);
				m = Math.max(m, j - t.s + 1);
			}
		}
		return m;
	}

	class T implements Comparable<T> {
		int s, e;

		public T(int s, int e) {
			this.s = s;
			this.e = e;
		}

		public int compareTo(T t) {
			return (t.e - t.s) - (e - s);
		}
	}
}
