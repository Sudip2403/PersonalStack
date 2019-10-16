package com.self.amazon.modules.BitManipulation;

public class SingleNumber {

	public static void main(String[] args) {
		int n = singleNumber(new int[] {1, 10, 2, 5, 10, 1, 20, 5, 2});
		System.out.println(n);
	}
	
	public static int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			//System.out.println("--------" + x + "^" + a + "=" + (x ^ a));
			x = x ^ a;
		}
		return x;
	}
}
