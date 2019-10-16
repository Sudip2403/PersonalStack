package com.practice;

import java.util.ArrayList;
import java.util.List;

public class AllBalancedParanthesis {

	public static void main(String[] args) {
		int n = 20;
		System.out.println(balancedParens(n));
	}

	public static List<String> balancedParens(int n) {
		List<String> r = new ArrayList<>();
		b(n, n, r, "");
		return r;
	}

	private static void b(int m, int n, List<String> l, String s) {
		if (m == 0 && n == 0) {
			l.add(s);
			return;
		}
		if (m == 0 || n == 0)
			return;
		String y = s;
		for (int i = m; i > 0; i--) {
			b(i - 1, n, l, y + "(");
			for (int j = n; j > 0; j--) {
				b(i - 1, j - 1, l, y + ")");
			}
		}
	}
}
