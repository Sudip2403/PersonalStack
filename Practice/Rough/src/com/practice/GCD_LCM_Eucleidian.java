package com.practice;

public class GCD_LCM_Eucleidian {

	public static void main(String[] args) {
		//long a = 3292937, b = 175597;
		long a = 15015, b = 10010;
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}
	
	static long gcd(long a, long b){
		long p = a > b ? a: b, q = a > b ? b: a; 
		while(p % q != 0){
			p = p % q;
			long t = p > q ? p: q; 
			q = p > q ? q: p;
			p = t;
		}
		return q;
	}
	
	static long lcm(long a, long b){
		return (a * b)/gcd(a, b); 
	}

}
