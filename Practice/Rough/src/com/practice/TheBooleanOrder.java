package com.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TheBooleanOrder {

	public static void main(String[] args) {
		// String operands = "ttftff", operators = "|&^&&";
		String operands = "tft", operators = "^&";
		System.out.println(new TheBooleanOrder(operands, operators).solve());
	}

	char[] c = null;
	char[] p = null;

	public TheBooleanOrder(final String operands, final String operators) {
		this.c = operands.toCharArray();
		this.p = operators.toCharArray();
	}

	public BigInteger solve() {
		int n = c.length;
		List<Boolean>[][] d = new List[n][n];
		for (int k = 0; k < n; k++) {
			List<Boolean> h = new ArrayList<>();
			h.add(c[k] == 't');
			d[k][k] = h;
		}
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int j = i + k;
				if (j < n) {
					List<Boolean> h = new ArrayList<>();
					if (k == 1)
						h.add(f(c[i] == 't', c[j] == 't', i));
					else {
						for (int p = i; p < j; p++) {
							if (d[p][j] != null && d[i][p] != null) {
								for (boolean u : d[i][p])
									for (boolean v : d[p][j])
										h.add(f(u, v, i));
							}
						}
					}
					d[i][j] = h;
				}
			}
		}
		BigInteger r = BigInteger.ZERO;
		if (d[0][n - 1] != null) {
			for (boolean b : d[0][n - 1]) {
				if (b)
					r = r.add(BigInteger.ONE);
			}
		}
		return r;
	}

	private boolean f(boolean a, boolean b, int i) {
		char y = p[i];
		return ((y == '&' ? (a & b) : y == '^' ? (a ^ b) : (a | b)));
	}
}