package com.self.amazon.modules.Maths;

public class FactorialTrailingZero {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(252));
	}
	
	public static int trailingZeroes(int n) {
		if (n < 0)
			return -1;
	 
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
	 
		return count;
	}
}
