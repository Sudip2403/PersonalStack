package com.practice;

public class IsPalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

	static boolean isPalindrome(int x) {
		int n = (int) Math.pow(10, (int) Math.log10(x));
		if (x < 0)
			return false;
		while (x > 0) {
			if (n == 1)
				return true;
			if (x % 10 != x / n)
				return false;
			x = (x % n) / 10;
			n /= 100;
		}
		return true;
	}
}
