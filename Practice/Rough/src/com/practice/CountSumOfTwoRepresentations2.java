package com.practice;

import java.util.HashMap;
import java.util.Map;

public class CountSumOfTwoRepresentations2 {

	public static void main(String[] args) {
		int n = 93, l = 24, r = 58;
		System.out.println(new CountSumOfTwoRepresentations2().countSumOfTwoRepresentations2(n, l, r));
	}

	int countSumOfTwoRepresentations2(int n, int l, int r) {
		int p = 0;
		Map<Integer, Boolean> m = new HashMap<>();
		for (int i = l; i <= r; i++) {
			if ((n - i) >= l && (n - i) <= r && m.get(n - i) == null) {
				p++;
				m.put(i, true);
			}
		}
		return p;
	}

}
