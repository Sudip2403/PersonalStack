package com.practice;

public class Matches {

	public static void main(String[] args) {
		// System.out.println(Long.parseLong("000000010000000", 2));
		//System.out.println((int)('='));

		String[] a = { 
				 "      -         -           ", 
				 "  |    |         |         |", 
				 "      -    +    -    =      ", 
				 "  |  |           |         |", 
				 "      -         -           " };
		String[] r = new Matches().matches(a);
		for (String s : r) {
			System.out.print(s + ", ");
		}
	}

	long[] n = new long[] { 10794, 520, 8866, 8842, 2696, 10378, 10410, 8712, 10922, 10890 };
	int[] s = new int[] { 43, 45, 120, 47, 61 };
	// new no., no. of moves., no of sticks to take or add
	int[][][] nc = new int[][][] { { { 2, 2, 1 }, { 3, 2, 1 }, { 5, 2, 1 }, { 6, 1, 0 }, { 8, 1, -1 }, { 9, 1, 0 } },
			{ { 7, 1, -1 } }, { { 3, 1, 0 }, { 5, 2, 0 }, { 6, 2, -1 }, { 8, 2, -2 }, { 9, 2, -1 }, { 0, 2, -1 } },
			{ { 2, 1, 0 }, { 4, 2, 1 }, { 5, 1, 0 }, { 6, 2, -1 }, { 7, 2, 2 }, { 8, 2, -2 }, { 9, 1, -1 },
					{ 0, 2, -1 } },
			{ { 1, 2, -2 }, { 5, 1, 0 }, { 7, 2, 1 }, { 9, 2, -2 } },
			{ { 2, 2, 0 }, { 3, 1, 0 }, { 4, 2, 1 }, { 6, 1, -1 }, { 8, 2, -2 }, { 9, 1, 0 }, { 0, 2, -1 } },
			{ { 2, 2, 1 }, { 3, 2, 1 }, { 8, 1, -1 }, { 9, 1, 0 }, { 0, 1, 0 } },
			{ { 1, 1, 1 }, { 3, 2, -2 }, { 4, 2, -1 } },
			{ { 2, 2, 2 }, { 3, 2, 2 }, { 5, 2, 2 }, { 6, 1, 1 }, { 9, 1, 1 }, { 0, 1, 1 } },
			{ { 2, 2, 1 }, { 3, 1, 1 }, { 4, 2, 2 }, { 5, 1, 1 }, { 6, 1, 0 }, { 8, 1, -1 }, { 0, 1, 0 } } };

	String[] matches(String[] a) {
		String e = eq(a);
		System.out.println(e);
		return new String[] {};
	}

	String eq(String[] a) {
		int m = a[0].length();
		String e = "";
		for (int i = 0; i < m; i += 5) {
			String h = "";
			for (int g = 0; g < 5; g++) {
				for (int f = i; f < i + 3; f++) {
					h += a[g].charAt(f) == ' ' ? 0 : 1;
					if (a[g].charAt(f) == s[0]) {
						e += '+';
						break;
					} else if (a[g].charAt(f) == s[2]) {
						e += 'x';
						break;
					} else if (a[g].charAt(f) == s[3]) {
						e += '/';
						break;
					} else if (a[g].charAt(f) == s[4]) {
						e += '=';
						break;
					}
				}
			}
			long v = Long.parseLong(h, 2);
			if (v == 128) {
				e += '-';
				continue;
			}
			for (int k = 0; k < 10; k++) {
				if (n[k] == v) {
					e += k;
					break;
				}
			}
		}
		return e;
	}

}
