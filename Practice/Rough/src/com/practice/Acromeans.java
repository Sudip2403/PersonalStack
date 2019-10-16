package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Acromeans {

	public static void main(String[] args) {
		String[] a = { "S.O.L.I.D", "PDF", "POC", "AVI", "YAGNI", "IS-IS (rp)" };
		String[] m = { "Portable Document", "Intermediate System - Intermediate System (routing protocol)",
				"SRP, OCP, LSP, ICP, DIP", "Proof of concept", "You ain't gonna need it!" };
		int[] r = new Acromeans().acromeans(a, m);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}

	int[] acromeans(String[] a, String[] m) {
		List<P> s = new ArrayList<>();
		Map<String, Boolean> h = new HashMap<>();
		for (int i = 0; i < m.length; i++) {
			String[] y = m[i].toLowerCase()
					/* .replaceAll("[^a-zA-Z0-9 ]", "") */.split(" ");
			String g = "";
			for (int j = 0; j < y.length; j++) {
				g += y[j].isEmpty() ? ""
						: (y[j].charAt(0) == '(' ? (y[j].charAt(0) + "" + y[j].charAt(1))
								: y[j].charAt(y[j].length() - 1) == ')' ? (y[j].charAt(0) + ")") : y[j].charAt(0) + "");
			}

			if (!h.containsKey(g))
				s.add(new P(g, i));
			h.put(g, true);
		}
		int n = a.length;
		int[] r = new int[n];
		Arrays.fill(r, -1);
		for (int i = 0; i < n; i++) {
			Collections.sort(s);
			int k = Collections.binarySearch(s, new P(a[i].toLowerCase().replaceAll("[. ]", ""), 0));
			if (k >= 0) {
				r[i] = s.get(k).i;
				s.remove(k);
			}
		}
		return r;
	}

	class P implements Comparable<P> {
		String s;
		int i;

		public P(String s, int i) {
			this.s = s;
			this.i = i;
		}

		public int compareTo(P p) {
			return s.compareTo(p.s);
		}

		public int hashCode() {
			return s.hashCode();
		}

		public boolean equals(Object o) {
			return ((P) o).s.compareTo(s) == 0;
		}
	}

}
