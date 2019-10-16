package com.practice;

import java.math.BigInteger;

public class AdditiveNumbers {

	public static void main(String[] args) {
		// String num = "112358";
		// String num = "1991001997777199107976";
		// String num = "199100199";
		// String num = "112";
		// String num = "101";
		// String num = "000";
		//String num = "0235813";
		String num = "1023";
		System.out.println(new AdditiveNumbers().isAdditiveNumber(num));
	}

	public boolean isAdditiveNumber(String num) {
		int n = num.length(), i = 1;
		if (num == null || (num != null && num.length() < 3))
			return false;
		while (i < n) {
			boolean f = false;
			while (i < n - 1) {
				if (i > 1 && num.startsWith("0"))
					return false;
				for (int j = i + 1; j < n; j++) {
					if ((num.charAt(i) != '0' || i == 1) && j < n && (num.charAt(j) != '0' || j == i + 1)
							&& checkForAdditives(num.substring(0, i), num.substring(i, j), num, j, n)) {
						f = true;
						break;
					}
				}
				i++;
				if (f)
					break;
			}
			i++;
			if (f)
				return true;
		}
		return false;
	}

	boolean checkForAdditives(String a, String b, String num, int i, int n) {
		BigInteger p = new BigInteger(a), q = new BigInteger(b);
		while (i < n) {
			BigInteger r = p.add(q);
			int l = r.toString().length();
			if (num.length() < i + l || !num.substring(i, i + l).equals(r.toString()))
				return false;
			p = q;
			q = r;
			i += l;
		}
		return true;
	}
}
