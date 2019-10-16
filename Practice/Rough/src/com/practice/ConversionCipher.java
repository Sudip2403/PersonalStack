package com.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConversionCipher {

	public static void main(String[] args) {
		int steps = 15;
		String start = "A";
		String target = "A";
		String[][] rules = { { "B", "A" }, { "A", "B" }, { "A", "BB" } };

		System.out.println(new ConversionCipher().conversionCipher(steps, start, target, rules));
	}

	boolean conversionCipher(int steps, String start, String target, String[][] rules) {
		Stack<String> l = new Stack<>();
		l.add(start);
		while (steps > 0) {
			Set<String> i = new HashSet<>();
			while (!l.isEmpty()) {
				i.addAll(c(rules, l.pop()));
			}
			l.addAll(i);
			steps--;
		}
		while (!l.isEmpty()) {
			if (l.pop().equals(target))
				return true;
		}
		return false;
	}

	Set<String> c(String[][] rs, String s) {
		Set<String> r = new HashSet<>();
		for (int i = 0; i < rs.length; i++) {
			String a = rs[i][0];
			int k = a.length();
			int j = 0;
			while (j < s.length()) {
				if (s.charAt(j) == a.charAt(0) && j + k <= s.length() && s.substring(j, j + k).equals(a))
					r.add(s.substring(0, j) + rs[i][1] + s.substring(j + k, s.length()));
				j++;
			}
		}
		return r;
	}

}
