package com.practice;

import java.util.ArrayList;
import java.util.List;

public class SplitPerLine {

	public static void main(String[] args) {
		String t = "Wert 1; Wert 2,...Wert 30 sind Werte, aus denen die Anzahl der Argumente errechnet wird.";
		int p = 22;
		String[] r = new SplitPerLine().splitPerLine(t, p);
		for (String string : r) {
			System.out.println(string);
		}
	}
	
	String[] splitPerLine(String t, int p) {
		List<String> l = new ArrayList<>();
		int n = t.length(), i = 0, b = 0, e = 0, c = 0;
		while (i < n) {
			if (t.charAt(i) == ' ')
				e = i;
			if (c == p - 1) {
				l.add(t.substring(b, e));
				c = i - e;
				e += 1;
				b = e;
			}
			i++;
			c++;
		}
		l.add(t.substring(b, n));
		return l.toArray(new String[l.size()]);
	}

}
