package com.practice;

public class BinomialExpansion {

	public static void main(String[] args) {
		// System.out.println("625m^4+1500m^3+1350m^2+540m+81".equals(BinomialExpansion.expand("(x-1)^1")));
		// System.out.println("8x^3-36x^2+54x-27".equals(BinomialExpansion.expand("(2x-3)^3")));
		// System.out.println("1".equals(BinomialExpansion.expand("(7x-7)^0")));
		System.out.println("81t^2".equals(BinomialExpansion.expand("(-n-12)^5")));
	}

	// (ax+b)^n
	public static String expand(String expr) {
		System.out.println(expr);
		int n = Integer.parseInt(expr.substring(expr.indexOf("^") + 1, expr.length())), m = n;
		expr = expr.substring(expr.indexOf("(") + 1, expr.indexOf(")"));
		char t = expr.substring(1, expr.length()).contains("+") ? '+' : '-';
		int a = (expr.lastIndexOf(t) - 1) == 0 ? 1
				: expr.substring(0, (expr.lastIndexOf(t) - 1)).equals("-") ? -1
						: expr.substring(0, (expr.lastIndexOf(t) - 1)).equals("+") ? 1
								: Integer.parseInt(expr.substring(0, (expr.lastIndexOf(t) - 1)));
		int b = Integer.parseInt(expr.substring(expr.lastIndexOf(t), expr.length()));
		String v = expr.substring(expr.lastIndexOf(t) - 1, expr.lastIndexOf(t));

		if (n == 0)
			return "1";

		long[] r = new long[n + 1];
		r[0] = b;
		r[1] = a;
		while (n > 1) {
			long[] e = new long[m + 1];
			for (int i = 0; i <= m; i++) {
				e[i] += (r[i] * b);
				if (i + 1 <= m)
					e[i + 1] += (r[i] * a);
			}
			r = e;
			n--;
		}
		String p = "";
		for (int i = m; i > 0; i--) {
			if (r[i] == 0)
				continue;
			if (i < m && r[i] > 0)
				p += '+';
			if (r[i] == 1 && i == 1)
				p += v;
			else if (r[i] == -1 && i == 1)
				p += "-" + v;
			else if (r[i] == 1 && i > 1)
				p += v + "^" + i;
			else if (r[i] == -1 && i > 1)
				p += "-" + v + "^" + i;
			else if (i == 1)
				p += r[i] + v;
			else
				p += r[i] + v + "^" + i;
		}
		if (r[0] != 0) {
			if (r[0] > 0)
				p += '+';
			p += r[0];
		}

		System.out.println("------ " + p);
		return p;
	}

}
