package com.practice;

public class PrimeFactors {

	public static void main(String[] args) {
		int n = 105;
		System.out.println(new PrimeFactors().prime_factors(n));
	}
	String prime_factors(int n) {
		if (n <= 1)
			return n + "";
		String r = "";
		while (n % 2 == 0) {
			r += 2 + "*";
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				r += i + "*";
				n /= i;
			}
		}
		if (n > 2)
			return r + n;
		else
			return r.substring(0, r.length() - 1);
	}

}
