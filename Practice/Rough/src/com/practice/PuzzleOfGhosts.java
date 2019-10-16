package com.practice;

public class PuzzleOfGhosts {

	public static void main(String[] args) {
		String[] l = { "aaabacadaeafagah", "aiajakalamanaoap", "aqarasatauavawax", "awaxayaz" };
		System.out.println(new PuzzleOfGhosts().puzzleOfGhost(l));
	}

	String puzzleOfGhost(String[] l) {
		String t = "";
		for (String s : l)
			t += s + "$";
		return f(0, "", t, "");
	}

	String f(int c, String s, String t, String f) {
		if (c(s, t)) {
			return s;
		}
		if (c == 26 && f.isEmpty())
			f = g(s, t, f);
		for (int i = c; i < 26; i++) {
			if (f.isEmpty())
				f = f(i + 1, (s.length() > 0 ? (s.substring(0, s.length() - 1)) : "") + (char) (i + 'a'), t, f);
		}
		return f;
	}

	String g(String s, String t, String f) {
		for (int i = 0; i < 26; i++)
			if (f.isEmpty())
				f = f(0, (s.length() > 0 ? (s.substring(0, s.length() - 1)) : "") + (char) (i + 'a') + 'a', t, f);
		return f;
	}

	boolean c(String a, String t) {
		if (t.contains(a))
			return false;
		return true;
	}
}
