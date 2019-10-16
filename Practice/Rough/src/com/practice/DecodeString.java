package com.practice;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(new DecodeString().decodeStr(s));
	}

	String decodeStr(String s) {
		char[] c = s.toCharArray();
		int n = c.length, j = 0;
		String m = "", p = "", r = "";
		Stack<String> st = new Stack<>();
		while (j < n) {
			if (i(String.valueOf(c[j])) > -1) {
				p += c[j];
				if (!m.isEmpty()) {
					st.add(m);
					m = "";
				}
			} else if (c[j] == ']') {
				if (!p.isEmpty()) {
					st.add(p);
					p = "";
				}
				if (!m.isEmpty()) {
					st.add(m);
					m = "";
				}
				String y = "";
				while (!st.isEmpty() && st.peek().equals("[")) {
					String t = st.pop();
					int z = i(t);
					if (z == -1)
						y = t;
					while (z > -1 && !y.isEmpty()) {
						r += y;
						z--;
					}
					if (y.isEmpty())
						r += '[' + z + ']';
					p = "";
				}
				if (!st.isEmpty())
					st.pop();
			} else if (c[j] == '[') {
				if (!p.isEmpty()) {
					st.add(p);
					p = "";
				}
				st.add("[");
			} else {
				if (!p.isEmpty()) {
					st.add(p);
					p = "";
				}
				m += c[j];
			}
			j++;
		}
		return r;
	}

	int i(String c) {
		int k = -1;
		try {
			k = Integer.parseInt(c);
		} catch (Exception e) {
		}
		return k;
	}

}
