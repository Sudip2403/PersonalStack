package com.practice;

public class BaseOr {

	public static void main(String[] args) {
		int x = 1, y = 2, b = 3;
		System.out.println(new BaseOr().baseOr(x, y, b));

	}

	int baseOr(int x, int y, int b) {
		try{
			return Integer.parseInt(Integer.toString(f(x, b) | f(y, b)) , b);	
		}catch (Exception e) {
			return x | y;
		}
	}

	int f(int a, int b) {
		return Integer.parseInt(Integer.toString(a, b));
	}
}
