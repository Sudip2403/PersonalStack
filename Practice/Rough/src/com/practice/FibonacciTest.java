package com.practice;

import java.math.BigInteger;

public class FibonacciTest {

	public static void main(String[] args) {
		//System.out.println(f());
		System.out.println(g());
	}

	static int N = 10000;

	static String g() {
		StringBuffer sb = new StringBuffer(1);
		for (int i = 2; i <= N; i++) {
			sb.append(i);
		}
		return sb.toString();
	}

	static int L = 2998;

	static String f() {
		StringBuffer sb = new StringBuffer(11);
		BigInteger a = BigInteger.ONE, b = BigInteger.ONE;
		while (L > 0) {
			BigInteger t = b;
			b = b.add(a);
			a = t;
			sb.append(b);
			L--;
		}
		return sb.toString();
	}
}
