package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetOfDuplicates {

	public static void main(String[] args) {
		int[] a = { 0, 0, 0, 0 };
		int[] r = new SetOfDuplicates().setOfDuplicate(a);
		for (Integer i : r) {
			System.out.print(i + ", ");
		}
	}

	int[] setOfDuplicate(int[] a) {
		int n = a.length;
		Map<Integer, Integer[]> m = new HashMap<>();
		List<Integer[]> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (m.get(a[i]) != null && m.get(a[i])[1] < 2) {
				l.add(new Integer[] { a[i], m.get(a[i])[0] });
				m.put(a[i], new Integer[] { i, 2 });
			} else if (m.get(a[i]) == null)
				m.put(a[i], new Integer[] { i, 1 });
		}
		Collections.sort(l, new Comparator<Integer[]>() {
			public int compare(Integer[] a, Integer[] b) {
				return a[1] - b[1];
			}
		});
		int[] r = new int[l.size()];
		for (int i = 0; i < r.length; i++)
			r[i] = l.get(i)[0];
		return r;
	}

}
