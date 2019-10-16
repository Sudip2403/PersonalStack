package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMeans1D {

	public static void main(String[] args) {
		int[] i = { -8, 2, -2, 7, -83, 11, 13, -7 };
		int k = 3;
		String[][] r = new KMeans1D().kmeans1D(i, k);
		for (String[] s : r) {
			System.out.println(s[0] + ", " + s[1]);
		}
	}

	String[][] kmeans1D(int[] i, int k) {
		Arrays.sort(i);
		Map<Integer, List<Integer>> m = new HashMap<>();
		int p = i.length, h = 0, g = 0, f = (int) Math.ceil(p * 1.0 / k);
		while (h < p) {
			List<Integer> l = new ArrayList<>();
			for (int j = h; j < h + f && j < p; j++)
				l.add(i[j]);
			m.put(g++, l);
			h += f;
		}

		// float[] c = new float[k];
		// for (int j = 0; j < k; j++)
		// c[j] = g(m.get(j));

		Map<Integer, List<Integer>> mc = new HashMap<>();
		f(m, mc, k, 1, 100);

		String[][] r = new String[m.size()][2];
		int q = 0;
		for (Map.Entry<Integer, List<Integer>> e : mc.entrySet()) {
			r[q][0] = String.valueOf(g(e.getValue()));
			r[q][1] = e.getValue().toString();
			q++;
		}
		return r;
	}

	void f(Map<Integer, List<Integer>> m, Map<Integer, List<Integer>> mc, int k, int i, int t) {
		if (t == 0)
			return;
		if (c(m, mc, k)) {
			h(m, mc, k);
			print(m);
		} else {
			h(mc, m, k);
			return;
		}
		if (i > k - 1)
			return;

		int a = m.get(i - 1).size() - 1;
		while (a > 0) {
			List<Integer> an = m.get(i - 1).subList(0, a);
			List<Integer> in2 = m.get(i - 1).subList(a, m.get(i - 1).size());
			m.get(i).addAll(in2);
			Collections.sort(m.get(i));
			m.put(i - 1, an);
			a -= 1;
			f(m, mc, k, i + 1, t - 1);
			if (i + 1 < k) {
				int b = m.get(i).size() - 1;
				while (b > 1) {
					List<Integer> bn = m.get(i).subList(0, b);
					List<Integer> in3 = m.get(i).subList(b, m.get(i).size());
					m.get(i + 1).addAll(in3);
					Collections.sort(m.get(i + 1));
					m.put(i, bn);
					b -= 1;
					f(m, mc, k, i + 1, t - 1);
				}
			}
		}

		int p = 1;
		while (p < m.get(i).size()) {
			List<Integer> bn = m.get(i).subList(p, m.get(i).size());
			List<Integer> in2 = m.get(i).subList(0, p);
			m.get(i - 1).addAll(in2);
			Collections.sort(m.get(i - 1));
			m.put(i, bn);
			p += 1;
			f(m, mc, k, i + 1, t - 1);
			if (i - 2 >= 0) {
				int b = m.get(i - 1).size(), q = 1;
				while (b > 1 && q < m.get(i - 1).size()) {
					List<Integer> bnn = m.get(i - 1).subList(q, m.get(i - 1).size());
					List<Integer> in3 = m.get(i - 1).subList(0, q);
					m.get(i - 2).addAll(in3);
					Collections.sort(m.get(i - 2));
					m.put(i - 1, bnn);
					q += 1;
					f(m, mc, k, i + 1, t - 1);
				}
			}
		}
	}

	void h(Map<Integer, List<Integer>> m, Map<Integer, List<Integer>> mc, int k) {
		for (int i = 0; i < k; i++) {
			mc.put(i, new ArrayList<>(m.get(i)));
		}
	}

	boolean c(Map<Integer, List<Integer>> m, Map<Integer, List<Integer>> mc, int k) {
		if (mc.isEmpty())
			return true;
		int a = 0, b = 0;
		for (int i = 0; i < k; i++) {
			float p = g(m.get(i));
			float q = g(mc.get(i));
			for (int l : m.get(i))
				a += Math.abs(p - l);
			for (int l : mc.get(i))
				b += Math.abs(q - l);
		}
		return a < b;
	}

	float g(List<Integer> a) {
		if (a.size() == 0)
			return 0;
		float e = 0;
		for (int i : a)
			e += i;
		return e / a.size();
	}

	void print(Map<Integer, List<Integer>> mc) {
		for (Map.Entry<Integer, List<Integer>> e : mc.entrySet()) {
			System.out.println(String.valueOf(g(e.getValue())) + ", " + e.getValue().toString());
		}
		System.out.println("================================");
	}
}
