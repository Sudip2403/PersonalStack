package com.practice;

public class FactLastDigits {

	public static void main(String[] args) {
		int n = 243, k = 3;
		System.out.println(new FactLastDigits().factLastDigits(n, k));
	}

	int factLastDigits(int n, int k) {
		long p = 1;
		for (int i = 2; i <= n; i++) {
			p *= i;
			while (p % 10 == 0 && p > 0)
				p /= 10;
			int y = (int) (Math.log10(p));
			if (y > k + 4)
				p = p % ((int) Math.pow(10, k + 4));
			System.out.println("==== " + p);
		}
		return (int) p % ((int) Math.pow(10, k));
	}
}
