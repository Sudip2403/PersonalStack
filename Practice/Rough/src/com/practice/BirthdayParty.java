package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayParty {

	public static void main(String[] args) {
		int[][] r = { { 1, 2, 1 }, { 2, 3, -1 }, { 3, 1, 1 } };
		int n = 3;
		System.out.println(new BirthdayParty().BirthdayParty(r, n));
	}

	boolean BirthdayParty(int[][] r, int n) {
		List<F>[] d = new List[n + 1];
		for (int i = 0; i < r.length; i++) {
			d[r[i][0]] = new ArrayList<>();
			d[r[i][0]].add(new F(r[i][1], r[i][2] == 1));
		}
		boolean[] p = new boolean[n + 1];
		Arrays.fill(p, true);
		int q = n;
		while (q > 0) {
			for (int i = 1; i <= n; i++) {
				boolean[] v = new boolean[n + 1];
				List<F> l = d[i];
				v[i] = true;
				for (F f : l) {
					if (f.f) {
						p[i] &= t(d, f.i, i, false, v, p);
					} else {
						p[i] &= !t(d, f.i, i, false, v, p);
					}
				}
			}
			q--;
		}
		for (int i = 1; i <= n; i++) {
			if (p[i])
				return true;
		}
		return false;
	}

	boolean t(List<F>[] d, int i, int s, boolean r, boolean[] v, boolean[] p) {
		if (d[i] == null)
			return true;
		if (!p[i])
			return false;
		if (i == s)
			return true;
		List<F> l = d[i];
		v[i] = true;
		for (F f : l) {
			if (f.f && !r && !v[f.i]) {
				r &= t(d, f.i, s, r, v, p);
			} else if (!r && !v[f.i]) {
				r &= !t(d, f.i, s, r, v, p);
			}
		}
		return r;
	}

	class F {
		int i;
		boolean f;

		public F(int i, boolean f) {
			this.i = i;
			this.f = f;
		}
	}

}
