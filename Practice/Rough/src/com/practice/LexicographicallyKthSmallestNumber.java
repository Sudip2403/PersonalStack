package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicallyKthSmallestNumber {

	int findKthNumber(int n, int k) {
		List<String> l = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			l.add(i + "");
		}
		Collections.sort(l);
		return Integer.parseInt(l.get(k - 1));
	}

	public static void main(String[] args) {
		int n = 1745, k = 15;
		System.out.println(new LexicographicallyKthSmallestNumber().findKthNumber(n, k));
	}
}
