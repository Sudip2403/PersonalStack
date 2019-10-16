package com.practice;

import java.util.Arrays;

public class Kaprekar {

	public static void main(String[] args) {
		int n = 2643;
		System.out.println(new Kaprekar().Kaprekar(n));
	}
	
	int[] kaprekar = { 495, 6174 };

	int Kaprekar(int n) {
		if (n <= 0 || n > 9999)
			return -1;
		int[] a = new int[10];
		int m = n;
		while (m > 0) {
			a[m % 10]++;
			m = m / 10;
		}
		int l = String.valueOf(n).length();
		for (int i = 0; i < 10; i++) {
			if ((a[i] == 3 && l == 3) || a[i] == 4)
				return -1;
		}
		
		int p = 0;
		while (n != kaprekar[0] && n != kaprekar[1]) {
			l = String.valueOf(n).length();
			String r = "";
			while (l < 4) {
				r += "0";
				l++;
			}
			r += n;
			char[] b = r.toCharArray();
			Arrays.sort(b);
			if (b.length == 3)
				n = (b[2] * 100 + b[1] * 10 + b[0]) - ((b[0] * 100 + b[1] * 10 + b[2]));
			else
				n = (b[3] * 1000 + b[2] * 100 + b[1] * 10 + b[0]) - ((b[0] * 1000 + b[1] * 100 + b[2] * 10 + b[3]));
			r = String.valueOf(n);
			p++;
		}
		return p;
	}

}
