package com.practice;

import java.util.ArrayList;
import java.util.List;

public class SmallestRotatedSequence {

	public static void main(String[] args) {
		String seq = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		StringBuffer y = new StringBuffer();
		for (int i = 0; i < 200000; i++) 
			y.append("ab");
		
		System.out.println(new SmallestRotatedSequence().smallestRotatedSequence(y.toString()));
	}

	int smallestRotatedSequence(String seq) {
		seq = seq.toLowerCase();
		int n = seq.length();
		List<T> l = new ArrayList<>();
		l.add(new T(-1, -1, 'z'));
		for (int i = 0; i < n; i++) {
			if (seq.charAt(i) <= l.get(0).k) {
				if (seq.charAt(i) < l.get(0).k)
					l = new ArrayList<>();
				l.add(new T(i, i, seq.charAt(i)));
			}
		}
		if (l.size() == 1)
			return l.get(0).i;
		if (l.size() == n)
			return 0;
		int h = 0;
		while (h < n) {
			List<T> r = new ArrayList<>();
			for (T t : l) {
				int k = t.c + 1;
				if (k >= n)
					k = 0;
				if (r.isEmpty())
					r.add(new T(t.i, k, seq.charAt(k)));
				else if (seq.charAt(k) <= r.get(0).k) {
					if (seq.charAt(k) < r.get(0).k)
						r = new ArrayList<>();
					r.add(new T(t.i, k, seq.charAt(k)));
				}
			}
			if (r.size() == 1)
				return r.get(0).i;
			l = new ArrayList<>(r);
			h++;
		}
		return 0;
	}

	class T {
		int i;
		int c;
		char k;

		public T(int i, int c, char k) {
			this.i = i;
			this.c = c;
			this.k = k;
		}
	}
}
