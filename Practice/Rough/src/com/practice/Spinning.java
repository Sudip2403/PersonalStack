package com.practice;

public class Spinning {

	public static void main(String[] args) {
		String s = "000000010000100000100010000000010000100000000010000000010000100000000010000000110000100000000010000000010000100000000010";
		System.out.println(new Spinning().spinning(s));
	}

	boolean spinning(String s) {
		int n = s.length();
		double f = 0, t = 360.0 / n;
		for (int i = 0; i < n; i++) {
			f += s.charAt(i) == '1' ? Math.cos(Math.toRadians(t * i)) : 0;
			f = Math.round(f * 10000) / 10000.0;
			System.out.println(f + ", " + 360 / n * i + "*");
		}
		System.out.println("======" + Math.round(f * 100) / 100.0);
		return Math.round(f * 100) / 100.0 == 0;
	}

}
