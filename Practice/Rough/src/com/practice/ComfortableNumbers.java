package com.practice;

import java.util.HashMap;
import java.util.Map;

public class ComfortableNumbers {

	public static void main(String[] args) {
		int l = 1, r = 9;
		System.out.println(new ComfortableNumbers().comfortableNumbers(l, r));
	}

	int comfortableNumbers(int l, int r) {
		int q = 0;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = l; i <= r; i++) {
			int s = 0, j = i;
			while (j > 0) {
				s += j % 10;
				j /= 10;
			}
			for (int p = i - s; p < i; p++) {
				if (p >= l && p <= r && p != i && p + m.get(p) >= i)
					q++;
			}
			m.put(i, s);
		}
		return q;
	}

}
