package com.practice;

import java.util.Arrays;

public class DrawStar {

	public static void main(String[] args) {
		int n = 5;
		String[] r = new DrawStar().drawStar2(n);
		for (String s : r) {
			System.out.println(s);
		}
	}

	String[] drawStar2(int n) {
		int r = (n - 1) * 4 + 1, c = (2 * n - 1) * 2 + (n - 2) * 2 + 1, a = 0, b = c / 2, p = 0, q = c / 2, k = n;
		char[][] y = new char[r][c];
		for (int i = 0; i < r; i++)
			Arrays.fill(y[i], ' ');
		while (k > 0) {
			y[a++][b++] = '*';
			y[p++][q--] = '*';
			k--;
		}
		a--;
		b++;
		p--;
		q--;
		k = 2 * n - 2;
		while (k > 0) {
			y[a][b] = '*';
			y[p][q] = '*';
			b += 2;
			q -= 2;
			k -= 2;
		}

		a++;
		b -= 3;
		p++;
		q += 3;
		k = n - 1;
		while (k > 0) {
			y[a++][b--] = '*';
			y[p++][q++] = '*';
			k--;
		}

		a--;
		p--;
		b++;
		q--;
		k = n;
		while (k > 0) {
			y[a++][b++] = '*';
			y[p++][q--] = '*';
			k--;
		}

		a--;
		b -= 3;
		p--;
		q += 3;
		k = 2 * n - 2;
		while (k > 0) {
			y[a][b] = '*';
			y[p][q] = '*';
			b -= 2;
			q += 2;
			k -= 2;
		}

		a++;
		b++;
		p++;
		q--;
		k = n - 1;
		while (k > 0) {
			y[a++][b--] = '*';
			y[p++][q++] = '*';
			k--;
		}

		String[] e = new String[r];
		for (int i = 0; i < r; i++)
			e[i] = "\"" + String.valueOf(y[i]) + "\"";
		return e;
	}

}
