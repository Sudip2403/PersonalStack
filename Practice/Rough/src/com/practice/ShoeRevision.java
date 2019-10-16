package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoeRevision {

	public static void main(String[] args) {
		int[][] s = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 0, 0 } };
		System.out.println(new ShoeRevision().ShoeRevision(s));
	}

	int ShoeRevision(int[][] s) {
		int n = s.length;
		Map<Integer, List<S>> m = new HashMap<>();
		for (int[] i : s) {
			if (i[2] == 1)
				continue;
			List<S> p = m.get(i[0]);
			if (p == null) {
				p = new ArrayList<>();
				p.add(new S(i[1] == 0, i[1] == 1));
			} else {
				boolean b = false;
				for (S t : p) {
					if (i[1] == 0 && t.r && !t.l) {
						t.l = true;
						b = true;
						break;
					} else if (i[1] == 1 && t.l && !t.r) {
						t.r = true;
						b = true;
						break;
					}
				}
				if (!b)
					p.add(new S(i[1] == 0, i[1] == 1));
			}
			m.put(i[0], p);
		}
		int c = 0;
		for (Map.Entry<Integer, List<S>> p : m.entrySet()) {
			List<S> l = p.getValue();
			for (S u : l)
				c += (u.l && u.r) ? 1 : 0;
		}
		return n - 2 * c;
	}

	class S {
		boolean l, r;

		public S(boolean l, boolean r) {
			this.l = l;
			this.r = r;
		}
	}
}
