package com.practice;

import java.util.Arrays;

public class ChessNotation {

	public static void main(String[] args) {
		String n = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR";
		System.out.println(new ChessNotation().chessNotation(n));
	}

	String chessNotation(String n) {
		String[] s = n.split("/");
		char[][] c = new char[8][8];
		for (int i = 0; i < 8; i++) {
			Arrays.fill(c[i], ' ');
			int k = 0;
			for (int j = 0; j < s[i].length(); j++) {
				char y = s[i].charAt(j);
				int t = n(y);
				if (t == 0)
					c[i][k++] = y;
				else
					k += t;
			}
		}
		String r = "";
		for (int i = 0; i < 8; i++) {
			String k = "";
			int f = 0;
			for (int j = 7; j >= 0; j--) {
				if (c[j][i] == ' ')
					f++;
				else {
					k += f > 0 ? (f + "" + c[j][i]) : c[j][i];
					f = 0;
				}
			}
			if (f > 0)
				k += f;
			r += (k + (i < 7 ? "/" : ""));
		}
		return r;
	}

	int n(char n) {
		try {
			return Integer.parseInt(String.valueOf(n));
		} catch (Exception e) {
			return 0;
		}
	}
}
