package com.practice;

public class Negative {

	public static void main(String[] args) {
		int a = 17, b = 8;
		System.out.println(new Negative().negative(a, b));
	}

	int negative(int a, int b) {
		String x = Integer.toBinaryString(a);
		String y = Integer.toBinaryString(b);
		System.out.println(x + ", " + y);
		System.out.println(Integer.toBinaryString(121));
		System.out.println(Integer.parseInt("00110110", 2));
		return 0;
	}

}
