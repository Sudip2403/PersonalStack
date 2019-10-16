package com.practice;

public class SquareRendezvous {

	public static void main(String[] args) {
		int s = 40;
		int[] a = { 0, 0 }, b = { 40, 40 };
		System.out.println(new SquareRendezvous().SquareRendezvous(s, a, b));
	}

	int SquareRendezvous(int s, int[] a, int[] b) {
		int d = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
		if (((a[0] == 0 && b[0] == s) || (a[0] == s && b[0] == 0))
				&& !((a[0] == 0 && a[1] == 0 && b[0] == s && b[1] == s)
						|| (a[0] == s && a[1] == s && b[0] == 0 && b[1] == 0)
						|| (a[0] == s && a[1] == 0 && b[0] == 0 && b[1] == s)
						|| (a[0] == 0 && a[1] == s && b[0] == s && b[1] == 0)))
			d += 2 * b[1] - (b[1] > a[1] ? Math.abs(a[1] - b[1]) : 0);
		else if (((a[1] == 0 && b[1] == s) || (a[1] == s && b[1] == 0))
				&& !((a[0] == 0 && a[1] == 0 && b[0] == s && b[1] == s)	
						|| (a[0] == s && a[1] == s && b[0] == 0 && b[1] == 0)
						|| (a[0] == s && a[1] == 0 && b[0] == 0 && b[1] == s)
						|| (a[0] == 0 && a[1] == s && b[0] == s && b[1] == 0)))
			d += 2 * b[0] - (b[0] > a[0] ? Math.abs(a[0] - b[0]) : 0);
		return Math.min(d, 4 * s - d);
	}

}
