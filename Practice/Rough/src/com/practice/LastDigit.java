package com.practice;

public class LastDigit {

	public static void main(String[] args) {
		System.out.println(new LastDigit().lastDigit(2, 5));
	}

	int lastDigit(int a, int b) {
		int k = 1;
		while (b > 0) {
			k = (k * a % 10);
			b--;
		}
		return k;
	}
}
