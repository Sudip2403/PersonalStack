package com.practice;

import java.util.Arrays;
import java.util.Stack;

public class CryptarithmsDelux {

	public static void main(String[] args) {
		String[] c = { "ALFA", "+", "BETA", "+", "GAMA", "=", "DELTA" };
		/*String[] c = { "(", "J", "+", "O", "+", "I", "+", "N", "+", "T", ")", "*", "(", "J", "+", "O", "+", "I", "+",
				"N", "+", "T", ")", "*", "(", "J", "+", "O", "+", "I", "+", "N", "+", "T", ")", "=", "JOINT" };*/
		String[][] r = new CryptarithmsDelux().Cryptarithms_Deluxe(c);
		/*
		 * for (int i = 0; i < r.length; i++) {
		 * System.out.println(r[i].toString()); }
		 */
	}

	String[][] Cryptarithms_Deluxe(String[] s) {
		int[] a = new int[26];
		Arrays.fill(a, -1);
		boolean[] d = new boolean[10];
		int[] sc = new int[26];
		for (String b : s) {
			if (c(b))
				continue;
			for (int i = 0; i < b.length(); i++) {
				if (a[b.charAt(i) - 'A'] == -1) {
					a[b.charAt(i) - 'A'] = 0;
				}
			}
			sc[b.charAt(0) - 'A'] = 1;
		}

		String r = p(a, d, sc, 0, s, s.length, "");
		System.out.println(r);
		return null;
	}

	String p(int[] a, boolean[] d, int[] sc, int i, String[] s, int n, String lex) {
		if (i == 26)
			return lex;
		if (a[i] == -1)
			lex = p(a, d, sc, i + 1, s, n, lex);
		else if (a[i] != -1) {
			int k = 0;
			if (sc[i] == 1)
				k = 1;
			for (int j = k; j < 10; j++) {
				if (!d[j]) {
					d[j] = true;
					a[i] = j;
					lex = p(a, d, sc, i + 1, s, n, lex);
					d[j] = false;
				}
			}
			String r = f(a, s, 0, n, "", "");
			if (lex.compareTo(r) < 0)
				lex = r;
		}
		return lex;
	}

	String f(int[] a, String[] s, int i, int n, String p, String lex) {
		if (i == n) {
			if (e(p.substring(0, p.indexOf("="))) == e(p.substring(p.indexOf("=") + 1, p.length()))
					&& lex.compareTo(p) < 0)
				lex = p;
			return lex;
		}
		String r = s[i];
		if (c(r)) {
			p += r;
		} else {
			char[] c = r.toCharArray();
			for (int j = 0; j < c.length; j++) {
				p += a[c[j] - 'A'];
			}
		}
		return f(a, s, i + 1, n, p, lex);
	}

	boolean c(String e) {
		if (e.equals("(") || e.equals(")") || e.equals("+") || e.equals("*") || e.equals("**") || e.equals("="))
			return true;
		return false;
	}

	int e(String e) {
		char[] c = e.toCharArray();
		int n = c.length, r = 0;
		String v = "";
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (c[i] >= 48 && c[i] <= 57)
				v += c[i];
			else {
				int q = Integer.parseInt(v);
				if (c[i] == '+')
					stack.push(q);
				else if (c[i] == '*') {
					int t = stack.pop();
					stack.push(t * q);
				} else if (i + 1 < n && c[i] == '*' && c[i + 1] == '*') {
					int t = stack.pop();
					stack.push((int) Math.pow(t, q));
				} else if (c[i] == '(') {
					int re = e(e.substring(i + 1, e.length()));
					stack.push(re);
					i = e.substring(i + 1, e.length()).indexOf(")");
				} else if (c[i] == ')') {
					int re = 0;
					while (!stack.isEmpty())
						re += stack.pop();
					return re;
				}
				v = "";
			}
		}
		if (!v.isEmpty())
			stack.push(Integer.parseInt(v));
		while (!stack.isEmpty())
			r += stack.pop();
		return r;
	}

}
