package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfAGivenSet {

	public static void main(String[] args) {
		String[] a = new String[] { "a", "b", "c" };
		subsets(Arrays.asList(a), 0, a.length, new ArrayList<String>());
		System.out.println("=========");
		subsets(a);
	}

	static void subsets(String[] a) {
		int n = 1 << a.length;
		for (int i = 0; i < n; i++) {
			List<String> l = new ArrayList<>();
			for (int j = 0; j < a.length; j++) {
				if ((i & (1 << j)) > 0)
					l.add(a[j]);
			}
			System.out.print(l + " ");
		}
	}

	static void subsets(List<String> a, int i, int n, List<String> list) {
		if (i == n) {
			System.out.print(list + " ");
			return;
		}
		list.add(a.get(i));
		subsets(a, i + 1, n, list);
		list.remove(a.get(i));
		subsets(a, i + 1, n, list);
	}
}
