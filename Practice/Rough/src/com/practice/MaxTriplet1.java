package com.practice;

public class MaxTriplet1 {

	public static void main(String[] args) {
		int[] l = { 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5 };
		int m = 5;
		System.out.println(new MaxTriplet1().maxTriplet(l, m));
	}

	int maxTriplet(int[] l, int m) {
		int[] d = new int[m + 1], a = new int[m + 1], b = new int[m + 1];
		int y = 0;
		for (int k : l) {
			a[k]++;
			b[k]++;
		}
		d[0] = a[0] / 3;
		d[1] = d[0] + a[1] / 3;
		y = Math.min(Math.min(a[0], a[1]), a[2]);
		d[2] = Math.max(d[1] + a[2] / 3, y + d[0] / 3 + d[1] / 3);
		for (int i = 3; i <= m; i++) {
			y = Math.min(Math.min(a[i - 2], a[i - 1]), a[i]);
			d[i] = Math.max(d[i - 1] + a[i] / 3,
					(d[i - 3] + y + (a[i - 2] - y) / 3 + (a[i - 1] - y) / 3 + (a[i] - y) / 3));
			if (i - 4 >= 0) {
				int o = 0;
				boolean g = true;
				if (b[i - 4] <= b[i - 3] && b[i - 3] <= b[i - 2])
					o = b[i - 4];
				else
					g = false;

				if (g && b[i - 2] - o <= b[i - 1])
					o += b[i - 3] - o;
				else
					g = false;

				if (g && b[i - 1] - o <= b[i])
					o += b[i - 1] - o;
				else
					g = false;
				if (g)
					d[i] = Math.max(d[i], o + (i - 5 >= 0 ? d[i - 5] : 0));
			}
		}
		return d[m];
	}

}
