package com.practice;

public class PageNumberingWithInk {

	public static void main(String[] args) {
		int c = 2, n = 5;
		System.out.println(new PageNumberingWithInk().pagesNumberingWithInk(c, n));
	}

	int pagesNumberingWithInk(int c, int n) {
		int p = (int) Math.log10(c);
		if (n < (p + 1))
			return c - 1;
		int m = (int) (Math.pow(10, p + 1));
		int r = (m - c) * (p + 1);
		if (n < r)
			return c + (n - (p + 1)) / (p + 1);
		else {
			n = n - (m - c) * (p + 1);
			return pagesNumberingWithInk(m, n);
		}
	}

}
