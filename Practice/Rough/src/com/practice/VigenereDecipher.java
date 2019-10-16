package com.practice;

public class VigenereDecipher {

	public static void main(String[] args) {
		String t = "Hfnos, Xqupi!", k = "abcdef";
		System.out.println(new VigenereDecipher().vigenereDecipher(t, k));
	}

	static int[][] a = new int[26][26];
	static {
		p();
	}

	String vigenereDecipher(String t, String k) {
		String r = "";
		int p = 0;
		for (int i = 0; i < t.length(); i++) {
			if (p == k.length())
				p = 0;
			while (i < t.length() && !(u(t.charAt(i)) || l(t.charAt(i))))
				i++;
			while (!(u(k.charAt(p)) || l(k.charAt(p)))) {
				p++;
				if (p == k.length())
					p = 0;
			}
			if (i < t.length()) {
				char f = k.charAt(p), g = t.charAt(i);
				int x = l(f) ? (f - 'a') : (f - 'A'), y = l(g) ? (g - 'a') : (g - 'A'), c = 0;
				for (int u = 0; u < 26; u++) {
					if (a[x][u] == y)
						c = y;
				}
				r += (char) (c + (l(g) ? 'a' : 'A'));
			}
		}
		return r;
	}

	boolean l(char c) {
		return c >= 97 && c <= 122;
	}

	boolean u(char c) {
		return c >= 65 && c <= 90;
	}

	static void p() {
		for (int i = 0; i < 26; i++) {
			int k = i;
			for (int j = 0; j < 26; j++) {
				if (k == 26)
					k = 0;
				a[i][j] = k++;
			}
		}
	}

}
