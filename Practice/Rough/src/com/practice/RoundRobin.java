package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RoundRobin {

	public static void main(String[] args) {
		String[][] r = { { "Real Madrid", "0", "2", "FC Barcelona" },
				{ "Manchester United", "2", "1", "Real Madrid" } };
		String[][] t = new RoundRobin().roundRobin(r);
		for (String[] s : t) {
			for (String st : s) {
				System.out.print(st + ", ");
			}
			System.out.println();
		}
	}

	String[][] roundRobin(String[][] r) {
		int n = r.length;
		Map<String, T> m = new HashMap<>();
		List<String> l = new ArrayList<>();
		List<String> te = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			T t = m.get(r[i][0]);
			T u = m.get(r[i][3]);
			if (t == null)
				t = new T();
			if (u == null)
				u = new T();
			int a = f(r[i][1]), b = f(r[i][2]);
			m.put(r[i][0], new T(r[i][0], t.a + 1, t.b + (a > b ? 1 : 0), t.c + (a == b ? 1 : 0), t.d + (a < b ? 1 : 0),
					t.e + a, t.f + b, t.h + (a > b ? 3 : (a == b ? 1 : 0))));
			m.put(r[i][3], new T(r[i][3], u.a + 1, u.b + (b > a ? 1 : 0), u.c + (a == b ? 1 : 0), u.d + (b < a ? 1 : 0),
					u.e + b, u.f + a, u.h + (b > a ? 3 : (a == b ? 1 : 0))));

			if (r[i][0].compareTo(r[i][3]) < 0)
				l.add(f(r[i][0], r[i][3]));
			else
				l.add(f(r[i][3], r[i][0]));

			if (!te.contains(r[i][0]))
				te.add(r[i][0]);
			if (!te.contains(r[i][3]))
				te.add(r[i][3]);
		}
		List<T> r0 = new ArrayList<>();
		for (Entry<String, T> t : m.entrySet())
			r0.add(t.getValue());
		Collections.sort(r0);
		Collections.sort(te);
		List<String> r1 = new ArrayList<>();
		for (int i = 0; i < te.size(); i++) {
			for (int j = 0; j < r0.size(); j++) {
				String a = te.get(i), b = r0.get(j).t;
				if (a.equals(b) || l.contains(f(a, b)) || l.contains(f(b, a)) || r1.contains(f(b, a)))
					continue;
				r1.add(f(a, b));
			}
		}
		String[][] re = new String[2][];
		re[0] = new String[r0.size()];
		for (int i = 0; i < r0.size(); i++)
			re[0][i] = r0.get(i).toString();
		re[1] = r1.toArray(new String[r1.size()]);
		return re;
	}

	int f(String a) {
		try {
			return Integer.parseInt(a);
		} catch (Exception e) {
			return -1;
		}
	}

	String f(String a, String b) {
		return a + " # " + b;
	}

	class T implements Comparable<T> {
		String t;
		int a, b, c, d, e, f, g, h;

		public T() {
		}

		public T(String t, int a, int b, int c, int d, int e, int f, int h) {
			this.t = t;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
			this.g = this.e - this.f;
			this.h = h;
		}

		public int compareTo(T t) {
			if (this.h > t.h)
				return -1;
			else if (this.h < t.h)
				return 1;
			else if (this.g > t.g)
				return -1;
			else if (this.g < t.g)
				return 1;
			else if (this.e > t.e)
				return -1;
			else
				return 1;
		}

		public String toString() {
			return t + " => MP:" + a + " | W:" + b + " | D:" + c + " | L:" + d + " | GF:" + e + " | GA:" + f + " | GD:" + g
					+ " | Pts:" + h;
		}
	}
}
