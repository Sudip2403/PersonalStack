package com.practice;

import java.math.BigInteger;

public class Anagrams {

	public static void main(String[] args) {
		String word = "AAAB";
		System.out.println(new Anagrams().listPosition(word));
	}

	public BigInteger listPosition(String word) {
		char[] c = word.toCharArray();
		int[] a = new int[26];
		int p = c.length;
		BigInteger[] B = new BigInteger[p + 1];
		B[0] = BigInteger.ONE; B[1] = BigInteger.ONE;

		for (int i = 0; i < p; i++) {
			a[c[i] - 'A']++;
		}

		for (int i = 2; i <= p; i++) {
			B[i] = B[i - 1].multiply(new BigInteger(i + ""));
		}

		BigInteger r = BigInteger.ZERO;
		for (int i = 0; i < p; i++) {
			char t = word.charAt(i);
			int cs = 0;
			for (int j = 0; j < t - 'A'; j++)
				cs += a[j];
			if(cs > 0)
				r = r.add(B[p - i - 1].divide(B[cs]).divide(B[p - i - 1 - cs]));
			a[t - 'A']--;
		}
		return r;
	}

}
