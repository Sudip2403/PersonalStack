package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConsecutiveNumbersSum {

	public int consecutiveNumbersSum(int N) {
		Map<Integer, Set<List<Integer>>> m = new HashMap<>();
		Set<List<Integer>> r = consecutiveNumbersSum(N, m);
		return r == null ? 0 : (r.size() + 1);
	}

	public Set<List<Integer>> consecutiveNumbersSum(int N, Map<Integer, Set<List<Integer>>> m) {
		if (N <= 2) {
			Set<List<Integer>> a = new HashSet<>();
			List<Integer> k = new ArrayList<>();
			k.add(N);
			a.add(k);
			return a;
		}
		if (m.containsKey(N))
			return m.get(N);
		Set<List<Integer>> a = new HashSet<>();
		List<Integer> p = new ArrayList<>();
		p.add(N);
		a.add(p);
		for (int i = 1; i < N / 2 + 1; i++) {
			if (N - 2 * i == 1) {
				List<Integer> k = new ArrayList<>();
				k.add(i);
				k.add(N - i);
				a.add(k);
			}

			Set<List<Integer>> b = consecutiveNumbersSum(i, m);
			Set<List<Integer>> c = consecutiveNumbersSum(N - i, m);
			if (!b.isEmpty() && !c.isEmpty()) {
				for (List<Integer> x : b) {
					for (List<Integer> y : c) {
						if (x.get(x.size() - 1) - y.get(0) == 1) {
							List<Integer> k = new ArrayList<>();
							k.addAll(x);
							k.addAll(y);
							Collections.sort(k);
							a.add(k);
						} else if (y.get(y.size() - 1) - x.get(0) == 1) {
							List<Integer> k = new ArrayList<>();
							k.addAll(y);
							k.addAll(x);
							Collections.sort(k);
							a.add(k);
						}
					}
				}
			}
		}
		if (!a.isEmpty())
			m.put(N, a);
		return a;
	}

	public static void main(String[] args) {
		int N = 9;
		System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(N));
	}
}
