package com.self.amazon.modules.BitManipulation;

public class ReverseBits {

	public static void main(String[] args) {
		ReverseBits bits = new ReverseBits();
		int n = bits.reverseBits(9);
		
		System.out.println(n);
	}
	
	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
	 
		return n;
	}
	 
	public int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
	 
		if ((a ^ b) != 0) {
			System.out.println("-----" + i + " " + j + "--------" + Integer.toBinaryString(n));
			System.out.println("-------------" + Integer.toBinaryString(n ^ (1 << i) | (1 << j)));
			return n ^= (1 << i) | (1 << j);
			
		}
	 
		return n;
	}
}
