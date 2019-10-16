package com.practice;

public class PermuteString {

	public static void main(String[] args) {
		String s = "abcabc";
		new PermuteString().permute(s.toCharArray(), 0, s.length() - 1);
	}

	void permute(char[] c, int p, int q) {
		if (p == q)
			System.out.print(String.valueOf(c) + " ");
		else {
			for (int i = p; i <= q; i++) {
				swap(c, p, i);
				permute(c, p + 1, q);
				swap(c, p, i);
			}
		}
	}

	void swap(char[] c, int i, int j) {
		if (i == j)
			return;
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}

}
