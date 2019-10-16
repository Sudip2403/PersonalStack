package com.practice;

public class XepBai {

	public static void main(String[] args) {
		String s = "7R1R10R5R6R2R3R9R11R";
		System.out.println(new XepBai().xepBai(s));
	}

	boolean xepBai(String s) {
		int[][] a = new int[4][14];
		char[] c = s.toCharArray();
		int k = 0, n = c.length;
		String y = "";
		while (k < n) {
			if (c[k] >= 48 && c[k] <= 57)
				y += c[k];
			else {
				a[c[k] == 'C' ? 0 : c[k] == 'R' ? 1 : c[k] == 'B' ? 2 : 3][n(y)] = 1;
				y = "";
			}
			k++;
		}
		boolean f = false;
		for (int i = 0; i < 4; i++) {
			int p = 0;
			boolean o = false;
			for (int j = 0; j < 14; j++) {
				if (p == 3)
					break;
				if (a[i][j] == 0)
					p = 0;
				if (a[i][j] == 1) {
					p++;
					o = true;
				}
			}
			if (p >= 3)
				f = true;
			else if (o) {
				f = false;
				break;
			}
		}
		if (f)
			return true;
		for (int i = 0; i < 14; i++) {
			int p = 0;
			boolean o = false;
			for (int j = 0; j < 4; j++) {
				if (p == 3) {
					break;
				}
				if (a[j][i] == 1) {
					p++;
					o = true;
				}
			}
			if (p >= 3)
				f = true;
			else if (o) {
				f = false;
				break;
			}
		}
		return f;
	}

	int n(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}
}
