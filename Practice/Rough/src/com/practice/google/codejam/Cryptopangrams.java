package com.practice.google.codejam;

import java.math.BigInteger;

public class Cryptopangrams {

	static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger p = a.compareTo(b) > 0 ? a : b, q = a.compareTo(b) > 0 ? b : a;
		while (p.mod(q).compareTo(BigInteger.ZERO) != 0) {
			p = p.mod(q);
			BigInteger t = p.compareTo(q) > 0 ? p : q;
			q = p.compareTo(q) > 0 ? q : p;
			p = t;
		}
		return q;
	}
}
