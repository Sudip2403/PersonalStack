package com.self.amazon.modules.BitManipulation;

public class CircularBitShift {

	public static void main(String[] args) {
		System.out.println(rotate(7, 2));
	}
	
	public static int rotate(int bits, int k){
		System.out.println(Integer.toBinaryString(((bits >>> k) | (bits << (Integer.SIZE - k)))));
		return (bits >>> k) | (bits << (Integer.SIZE - k));	
	}
}
