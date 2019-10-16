package com.practice;

public class NthValue {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(new NthValue().nthValue(n));
	}

	int nthValue(int n) {
		double g = 1, f = n;
		while (f > 1)
			g *= f--;
		return (int) (Math.pow(Math.PI/2, n) / g * Math.pow(10, n));
	}

}
