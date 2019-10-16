package com.practice;

public class Cipher26 {

	public static void main(String[] args) {
		String m = "taiaiaertkixquxjnfxxdh";
		System.out.println(new Cipher26().cipher26(m));
	}

	String cipher26(String m) {
		char[] c = m.toCharArray();
		int n = c.length, p = c[0];
		String d = c[0] + "";
		for (int i = 1; i < n; i++) {
			if (c[i] >= p) {
				d += (char) (c[i] - p + 'a');
			} else {
				d += (char) (c[i] + 26 - p + 'a');
			}
			p = c[i];
		}
		return d;
	}

}
