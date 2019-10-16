package com.practice;

public class RepeatedSubStrings {

	public static void main(String[] args) {
		String a = "sweetsweetsweeta";
		System.out.println(new RepeatedSubStrings().stringIsRepeatedSubstring(a));
	}

	boolean stringIsRepeatedSubstring(String a) {
		char[] c = a.toCharArray();
		int n = c.length;
		int[] d = new int[n];
		d[0] = c[0] * 17;
		for (int i = 1; i < n; i++)
			d[i] = d[i - 1] + c[i] * 17;
		int p = 0;
		while (p < n - 1) {
			if ((d[n - 1] - d[p]) % d[p] == 0) {
				int t = p + 1, q = 0;
				while (q < n) {
					if (t < n && q < n && d[t] - d[q] != d[p])
						break;
					q = t;
					t += p + 1;
				}
				if (q >= n - 1)
					return true;

			} else
				p++;
		}
		return false;
	}

}
