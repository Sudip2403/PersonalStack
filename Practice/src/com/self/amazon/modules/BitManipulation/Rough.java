package com.self.amazon.modules.BitManipulation;

public class Rough {

	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-7));
		System.out.println(Integer.toBinaryString((-7 >> 2)));// arithmetic shift
		System.out.println(Integer.toBinaryString((-7 >>> 2)));//logical shift
		
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(2));
		
		System.out.println(Integer.toBinaryString(-2 << 1));
		System.out.println(Integer.toBinaryString((2 << 1)));
		
		System.out.println(Integer.toBinaryString((3 << 2)));
		System.out.println(Integer.toBinaryString((3 >> 2)));
		System.out.println(Integer.toBinaryString((-3 >> 2)));
		System.out.println(Integer.toBinaryString((-3 >>> 2)));
		
		//4294967296 2^32
		//2147483648 2^31
		System.out.println(Math.pow(2, 32));
		System.out.println(Integer.toBinaryString(1));
		//System.out.println(Integer.toBinaryString((445452547)));
	}
}
