package com.practice;

import java.math.BigInteger;

public class FibonacciWords {

	public static void main(String[] args) {
		String a = "1415926535";
		String b = "8979323846";
		int n = 35;

		System.out.println(new FibonacciWords().f(a, b, new BigInteger(String.valueOf(n))));
	}

	private char f(String a, String b, BigInteger n) {
		BigInteger p = new BigInteger(String.valueOf(a.length()));
		BigInteger q = new BigInteger(String.valueOf(b.length()));
		while (p.compareTo(n) < 0) {
			BigInteger r = new BigInteger(q.toString());
			q = p.add(q);
			p = r;
		}
		BigInteger i = f(p.subtract(BigInteger.ONE), new BigInteger(String.valueOf(a.length()))
				.add(new BigInteger(String.valueOf(b.length()))).subtract(BigInteger.ONE), n);
		if (i.compareTo(new BigInteger(String.valueOf(a.length()))) <= 0)
			return a.charAt(i.intValue());
		else
			return b.charAt(i.intValue() - b.length());
	}

	private BigInteger f(BigInteger n, BigInteger m, BigInteger i) {
		if (n.compareTo(m) <= 0)
			return i;
		BigInteger l = n.divide(new BigInteger("2"));
		BigInteger r = n.subtract(l);
		if (i.compareTo(l) <= 0)
			return f(l, m, i);
		else
			return f(r, m, i.subtract(l));
	}
}
