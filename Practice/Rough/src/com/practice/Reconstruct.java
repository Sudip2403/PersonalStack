package com.practice;

import java.util.Arrays;

public class Reconstruct {

	public static void main(String[] args) {
		String s = "oneonetwothreefivefourxissveenghteineni";
		// String s = "one";
		// String s = "niswoevntfiveene";
		System.out.println(new Reconstruct().reconstruct(s));
	}

	String reconstruct(String s) {
		char[] c = s.toCharArray();
		int[] a = new int[26];
		for (char y : c)
			a[y - 'a']++;
		String[] n = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] r = { "" };
		g(c.length, a, n, "", r);
		return r[0];
	}

	void g(int k, int[] a, String[] n, String h, String[] r) {
		if (k == 0) {
			String[] s = h.split(",");
			Arrays.sort(s);
			for (String u : s)
				if (!u.isEmpty())
					r[0] += u;
		}
		if (!r[0].isEmpty())
			return;
		for (int i = 0; i < 10; i++) {
			char[] g = n[i].toCharArray();
			if (f(0, a, g)) {
				f(1, a, g);
				if (r[0].isEmpty()) {
					g(k - n[i].length(), a, n, h + "," + i, r);
				}
				f(2, a, g);
			}
		}
	}

	boolean f(int p, int[] a, char[] b) {
		if (p == 0) {
			int[] t = new int[26];
			for (char c : b)
				t[c - 'a']++;
			for (int i = 0; i < 26; i++)
				if (a[i] < t[i])
					return false;
			return true;
		} else {
			for (char c : b) {
				if (p == 1)
					a[c - 'a']--;
				if (p == 2)
					a[c - 'a']++;
			}
		}
		return true;
	}
}
