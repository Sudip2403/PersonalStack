package com.practice;

import java.util.Arrays;

public class BillBoard {

	public static void main(String[] args) {
		String s = "GOOD MORN";
		int[] a = {2, 4};
		System.out.println(new BillBoard().billboard(s, a));
	}

	boolean billboard(String s, int[] a) {
		String[] p = s.split(" ");
		Arrays.sort(p);
		int i = 0, j = 0, k = 0;
		while (i < a[0] && k < p.length) {
			if (p[k].length() < a[1] - j + 1)
				j += p[k].length() + 1;
			else if (i + 1 < a[0] && p[k].length() <= a[1]) {
				i++;
				j = p[k].length() + 1;
			} else
				return false;
			k++;
		}
		if (k == p.length)
			return true;
		return false;
	}

}
