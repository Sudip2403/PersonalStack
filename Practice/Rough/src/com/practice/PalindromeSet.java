package com.practice;

public class PalindromeSet {

	public static void main(String[] args) {
		String[] a = { "7a" };
		int[] r = new PalindromeSet().palindromeSet(a);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}

	int[] palindromeSet(String[] a) {
		int n = a.length;
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			char[] c = a[i].toCharArray();
			int q = c.length - 1;
			r[i] += f(c, 0, q, 48, 57) + f(c, 0, q, 97, 122);
		}
		return r;
	}

	int f(char[] c, int p, int q, int l, int r) {
		int n = q;
		while (q >= p) {
			while (p <= n && !(c[p] <= r && c[p] >= l))
				p++;
			while (q >= 0 && !(c[q] <= r && c[q] >= l))
				q--;
			if (p <= n && q >= 0 && c[p] != c[q])
				return 0;
			if(p == q)
				return 1;
			p++;
			q--;
		}
		return p <= n && q >= 0 && p >= q ? 1 : 0;
	}

}
