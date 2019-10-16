package com.practice;

public class PrefixFunction {

	public static void main(String[] args) {
		String s = "aaaaaaba";
		int[] r = new PrefixFunction().prefixFunctionNaive(s);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}

	int[] prefixFunctionNaive(String s) {
		int i = 0, j = 1, n = s.length(), t = 1;
		int[] p = new int[n];
		while (j < n) {
			while (i > 0 && s.charAt(i) != s.charAt(j))
				i = p[i - 1];
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				p[t++] = i;
			} else {
				p[t++] = 0;
				j++;
			}
		}
		return p;
	}

}
