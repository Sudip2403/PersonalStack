package com.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LetterCasePerm {

	public static void main(String[] args) {
		String s = "12345";
		String[] r = new LetterCasePerm().letterCasePerm(s);
		for (String sr : r) {
			System.out.print(sr + " ");
		}
	}

	String[] letterCasePerm(String s) {
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		int n = c.length, i = 0;
		Queue<String> q = new LinkedList<>();
		while (i < n && !((c[i] >= 97 && c[i] <= 122) || (c[i] >= 65 && c[i] <= 90)))
			i++;
		if (i > 0)
			q.add(s.substring(0, i));
		for (int k = i; k < n; k++) {
			if (q.isEmpty()) {
				q.add("" + c[k]);
				q.add(c(c[k]));
			} else {
				Set<String> p = new HashSet<>();
				while (!q.isEmpty()) {
					String u = q.poll();
					p.add(u + c[k]);
					p.add(u + c(c[k]));
				}
				q.addAll(p);
			}
		}
		return q.toArray(new String[q.size()]);
	}

	String c(char c) {
		return String.valueOf(c).toUpperCase();
	}

}
