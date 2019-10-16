package com.practice;

public class PrimeString {

	public static void main(String[] args) {
		String s = "bx";
		System.out.println(primeString(s));
	}

	public static boolean primeString(String s) {
		int n = s.length();
		if(n == 1)
			return true;
		for (int i = 1; i <= n / 2; i++) {
			String q = s.substring(0, i);
			if ((n - i) % i == 0) {
				int p = i;
				while (p + i <= n) {
					if (!s.substring(p, p + i).equals(q))
						break;
					p = p + i;
				}
				if (p == n)
					return false;
			}
		}
		return true;
	}

}
