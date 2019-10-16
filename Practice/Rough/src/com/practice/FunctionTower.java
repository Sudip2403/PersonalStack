package com.practice;

import java.util.ArrayList;
import java.util.List;

public class FunctionTower {

	public static void main(String[] args) {
		String[] t = { "[        1        ]   ", 
				       "  [x * 2][3][x + 9]   ",
				       " [ x + 5  ][ x * 10  ]",
				       "   [x + 1]     [x + 1]",
				       "[      x * 2      ]   " };
		System.out.println(new FunctionTower().functionTower(t));
	}

	int functionTower(String[] t) {
		List<P> p = new ArrayList<>();
		for (int i = 0; i < t.length; i++) {
			List<P> q = new ArrayList<>();
			char[] c = t[i].toCharArray();
			int s = 0;
			for (int j = 0; j < c.length; j++) {
				if (c[j] == '[')
					s = j;
				if (c[j] == ']') {
					String h = r(t[i].substring(s + 1, j));
					int u = f(h);
					if (u >= 0) {
						q.add(new P(s, j, u));
					} else {
						int v = 0;
						for (int k = 0; k < p.size(); k++) {
							P l = p.get(k);
							if ((s >= l.s && s <= l.e) || (j >= l.s && j <= l.e)
									|| (l.s >= s && l.s <= j) || (l.e >= s && l.e <= j))
								v += l.v;
						}
						q.add(new P(s, j, e(h, v)));
					}
				}
			}
			p = new ArrayList<>(q);
		}
		int r = 0;
		for (P e : p)
			r += e.v;
		return r;
	}

	int e(String s, int v) {
		boolean a = false;
		String n = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+')
				a = true;
			if (c >= '0' && c <= '9')
				n += c;
		}
		int y = f(n);
		return a ? (v + y) : (v * y);
	}

	int f(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}

	String r(String s) {
		return s.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
	}

	class P {
		int s, e, v;

		public P(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
	}
}
