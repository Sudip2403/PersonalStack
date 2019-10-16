package com.practice;

public class SwapNeighbouringDigits {

	public static void main(String[] args) {
		int n = 1234;
		System.out.println(new SwapNeighbouringDigits().swapNeighbouringDigits(n));
	}
	
	int swapNeighbouringDigits(int n) {
		int m = (int) Math.log10(n);
		int r = 0;
		while (n > 0) {
			int p = n / (int) Math.pow(10, m);
			n %= (int) Math.pow(10, m);
			int q = n / (int) Math.pow(10, m - 1);
			n %= (int) Math.pow(10, m - 1);
			r += q * Math.pow(10, m) + p * Math.pow(10, m - 1);
			m -= 2;
		}
		return r;
	}

}
