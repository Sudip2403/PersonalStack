package com.practice;

public class LeapFrog {

	public static void main(String[] args) {
		int[] a = { 3, 7, 2, 2, 1, 1, 3, 2, 7, 4, 1 };
		System.out.println(new LeapFrog().leapFrog(a));
	}

	int leapFrog(int[] a) {
		int i = 0;
		while (i < a.length && i + a[i] < a.length)
			i += a[i];
		return a[i];
	}
}
