package com.practice;

public class AfraidOfEven {

	public static void main(String[] args) {
		int[] seq = {7, 47, 5, 113, 73, 179, 53};
		int[] r = new AfraidOfEven().restoreProgression(seq);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}

	int M = 1000;//Integer.MAX_VALUE;

	public int[] restoreProgression(int[] seq) {
		int n = seq.length;
		if (n < 3)
			return seq;
		long d = seq[1] - seq[0];
		int i = 2;
		boolean p = true;
		while (i < n) {
			if (seq[i] - seq[i - 1] != d) {
				p = false;
				break;
			}
		}
		if (p)
			return seq;
		long[] r = new long[3];
		int a = seq[0], b = seq[1], c = seq[2];
		f(a, b, c, r, false);
		d = r[1] - r[0];
		seq[0] = (int) r[0];
		seq[1] = (int) r[1];
		seq[2] = (int) r[2];
		for (int j = 3; j < n; j++)
			seq[j] = (int) (seq[j - 1] + d);
		return seq;
	}

	private boolean f(long a, long b, long c, long[] r, boolean u) {
		if(a == 14 && c == 80)
			System.out.println("-------------" + b);
		if ((a + c) % b == 0 && (a + c) / 2 - a == c - (a + c) / 2) {
			r = new long[] { a, (a + c) / 2, c };
			return true;
		}
		if (a > M || b > M || c > M)
			return u;
		if (!u)
			u = f(a * 2, b, c, r, u);
		//if (!u)
		//	u = f(a, b * 2, c, r, u);
		if (!u)
			u = f(a, b, c * 2, r, u);

		return u;
	}
}
