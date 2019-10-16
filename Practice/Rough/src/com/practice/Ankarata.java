package com.practice;

import java.util.Arrays;

public class Ankarata {

	public static void main(String[] args) {
		int[] d = { 2, 1, 5, 3, 4 };
		String[] r = new Ankarata().ankaratra(d);
		for (String string : r) {
			System.out.println("'" + string + "'");
		}
	}

	char up = (char) Integer.parseInt("279a", 16), dn = (char) Integer.parseInt("2798", 16);

	String[] ankaratra(int[] d) {
		int p = 0, n = d.length, q = d[0] + 1 + d[n - 1], k = d[0] + 1;
		for (int i = 0; i < n; i++)
			p = Math.max(p, d[i]);
		for (int i = 1; i < n; i++)
			q += Math.abs(d[i - 1] - d[i]) + 1;

		char[][] c = new char[p + 1][q + 1];
		for (int i = 0; i <= p; i++)
			Arrays.fill(c[i], ' ');
		c[p - d[0]][d[0]] = up;
		c[p - d[0]][d[0] + 1] = dn;
		for (int i = 1; i < n; i++) {
			if (d[i] < d[i - 1]) {
				c[p - d[i]][d[i - 1] - d[i] + k] = dn;
				c[p - d[i]][d[i - 1] - d[i] + 1 + k] = up;
			}
			if (d[i] > d[i - 1]) {
				c[p - d[i]][d[i] - d[i - 1] + k] = up;
				c[p - d[i]][d[i] - d[i - 1] + 1 + k] = dn;
			}
			k += Math.abs(d[i] - d[i - 1]) + 1;
		}

		for (int i = 0; i <= p; i++) {
			for (int j = 0; j <= q; j++) {
				int x = i + 1;
				int y = j - 1;
				if (c[i][j] != ' ') {
					while (x <= p && y >= 0 && c[x][y] == ' ')
						c[x++][y--] = c[i][j];
				}
				x = i + 1;
				y = j + 1;
				if (c[i][j] != ' ') {
					while (x <= p && y <= q && c[x][y] == ' ')
						c[x++][y++] = c[i][j];
				}
			}
		}

		for (int i = 0; i <= p; i++) {
			for (int j = 0; j <= q; j++) {
				if (c[i][j] == up) {
					for (int t = i + 1; t <= p; t++)
						c[t][j] = up;
				}
				if (c[i][j] == dn) {
					for (int t = i + 1; t <= p; t++)
						c[t][j] = dn;
				}
			}
		}

		String[] r = new String[p + 1];
		for (int i = 0; i <= p; i++)
			r[i] = String.valueOf(c[i]);
		return r;
	}

}
