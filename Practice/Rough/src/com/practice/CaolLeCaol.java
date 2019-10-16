package com.practice;

import java.util.Arrays;

public class CaolLeCaol {

	public static void main(String[] args) {
		String w = "glacfidh";
		System.out.println(new CaolLeCaol().caolLeCaol(w));
	}
	
	boolean caolLeCaol(String w) {
		char[] c = w.toCharArray();
		int[] b = { 97, 111, 117, 225, 243, 250 };
		int[] s = { 101, 105, 233, 237 };
		boolean p = Arrays.binarySearch(b, c[0]) > -1, q = Arrays.binarySearch(s, c[0]) > -1;
		int n = c.length, k = p || q ? 0 : -1;
		for (int i = 1; i < n; i++) {
			int m = Arrays.binarySearch(b, c[i]);
			if (m > -1 && q && k != -1 && i - k > 1)
				return false;
			int o = Arrays.binarySearch(s, c[i]);
			if (o > -1 && p && k != -1 && i - k > 1)
				return false;
			if (m > -1) {
				p = true;
				q = false;
				k = i;
			} else if (o > -1) {
				q = true;
				p = false;
				k = i;
			}
		}
		return true;
	}

}
