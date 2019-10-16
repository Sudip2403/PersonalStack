package com.practice;

public class PrimeFact {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(new PrimeFact().primeFact(n));
	}

	static int L = 15001;
	static double[] f = new double[L];
	static {
		p();
	}

	int primeFact(int n) {
		return (int) f[n] + 1;
	}

	static void p() {
		int n = L * 11;
		int[] p = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			if (p[i] == 0) {
				int k = 2;
				while (i * k <= n)
					p[i * k++] = -1;
			}
		}
		int k = 1;
		for (int i = 2; i <= n; i++) {
			if (k == L)
				break;
			if (p[i] == 0) {
				f[k] = (f[k - 1] + Math.log10(i));
				k++;
			}
		}
	}
}
