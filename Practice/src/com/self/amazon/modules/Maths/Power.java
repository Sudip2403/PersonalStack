package com.self.amazon.modules.Maths;

public class Power {

	public static void main(String[] args) {
		Power power = new Power();
		double p = power.pow(-2, 3);
		
		System.out.println(p);
	}
	
	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
}
