package com.practice;

public class Boggle {

	public static void main(String[] args) {
		char[][] board = { { 'E', 'A', 'R', 'A' }, { 'N', 'L', 'E', 'C' }, { 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };
		String word = "BAILER";
		System.out.println(new Boggle(board, word).check());
	}

	int p = 0, q = 0;
	boolean[][] v;
	char[] c;
	int[] x = { 0, 1, 1, 1, 0, -1, -1, -1 };
	int[] y = { 1, 1, 0, -1, -1, -1, 0, 1 };
	char[][] b;

	public Boggle(final char[][] board, final String word) {
		p = board.length;
		q = board[0].length;
		c = word.toCharArray();
		v = new boolean[p][q];
		b = board;
	}

	public boolean check() {
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < q; j++) {
				if (c[0] == b[i][j]) {
					v[i][j] = true;
					boolean r = c(i, j, 1, c.length, false);
					if (r)
						return true;
					v[i][j] = false;
				}
			}
		}
		return false;
	}

	private boolean c(int cx, int cy, int k, int n, boolean f) {
		if (k == n)
			return true;
		for (int i = 0; i < 8; i++) {
			int xd = cx + x[i], yd = cy + y[i];
			if (xd >= 0 && yd >= 0 && xd < p && yd < q && !v[xd][yd] && b[xd][yd] == c[k]) {
				v[xd][yd] = true;
				f = c(xd, yd, k + 1, n, f);
				v[xd][yd] = false;
			}
		}
		return f;
	}
}
