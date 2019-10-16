package com.practice;

public class ReverseBits1 {

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(new ReverseBits1().reverseBits(n));
		System.out.println(Integer.toBinaryString(new ReverseBits1().reverseBits(n)));
		System.out.println(Long.parseLong("00111001011110000010100101000000", 2));
	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		long result = 0, i = 32;
		while (i >= 0) {
			long mask = (n & (1l << i));
			if (mask != 0)
				result |= (1 << (32 - i));
			i--;
		}
		return (int) result;
	}
}
