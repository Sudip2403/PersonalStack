package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MissUniversity {

	public static void main(String[] args) {
		int n = 6;
		int[][] c = { { 7, 190 }, { 34 }, { 164, 201, 15 }, { 201, 80 }, { 80, 7 }, { 128, 190, 15 } };
		Integer[] r = new MissUniversity().missUniversity(n, c);
		for (Integer i : r) {
			System.out.print(i + ", ");
		}
	}

	Integer[] missUniversity(int n, int[][] c) {
		Map<Integer, Integer[]> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < c[i].length; j++) {
				Integer[] a = m.get(c[i][j]);
				int p = j == 0 ? 3 : j == 1 ? 2 : 1, f = j == 0 ? 1 : 0, s = j == 1 ? 1 : 0;
				if (a == null)
					a = new Integer[] { 0, 0, 0 };
				a[0] += p;
				a[1] += f;
				a[2] += s;
				m.put(c[i][j], a);
			}
		}
		Set<Map.Entry<Integer, Integer[]>> s = m.entrySet();
		List<Map.Entry<Integer, Integer[]>> list = new ArrayList<>(s);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer[]>>() {
			public int compare(Entry<Integer, Integer[]> o1, Entry<Integer, Integer[]> o2) {
				Integer[] a = o1.getValue(), b = o2.getValue();
				if (a[0].compareTo(b[0]) > 0)
					return -1;
				if (a[0].compareTo(b[0]) < 0)
					return 1;
				if (a[1].compareTo(b[1]) > 0)
					return -1;
				if (a[1].compareTo(b[1]) < 0)
					return 1;
				if (a[2].compareTo(b[2]) > 0)
					return -1;
				if (a[2].compareTo(b[2]) < 0)
					return 1;
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		List<Integer> r = new ArrayList<>();
		int p = list.get(0).getValue()[0], f = list.get(0).getValue()[1], g = list.get(0).getValue()[2];
		r.add(list.get(0).getKey());
		for (int i = 1; i < c.length; i++) {
			if (list.get(i).getValue()[0] == p && list.get(i).getValue()[1] == f && list.get(i).getValue()[2] == g)
				r.add(list.get(i).getKey());
			else
				break;
		}
		return r.toArray(new Integer[r.size()]);
	}

}
