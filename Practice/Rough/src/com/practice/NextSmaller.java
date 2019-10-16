package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NextSmaller {

	public static void main(String[] args) {
		int n = 7234;
		System.out.println(new NextSmaller().nextSmaller(n));
	}

	int nextSmaller(int n) {
		int l = (int) Math.log10(n) + 1, p = l - 1;
		Integer[] a = new Integer[l];
		while (p >= 0) {
			a[p--] = n % 10;
			n /= 10;
		}
		Queue<N> q = new PriorityQueue<>();
		q.add(new N(a[l - 1], l - 1));
		p = l - 2;
		while (p >= 0) {
			Queue<N> k = new PriorityQueue<>();
			while (!q.isEmpty() && p >= 0) {
				N t = q.poll();
				if (t.n < a[p] && !(p == 0 && t.n == 0)) {
					int u = a[p];
					a[p] = t.n;
					a[t.i] = u;
					Arrays.sort(a, p + 1, a.length, new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o2.compareTo(o1);
						}
					});
					String r = "";
					for (int i = 0; i < l; i++)
						r += a[i];
					return Integer.parseInt(r);
				} else {
					k.add(t);
				}
			}
			k.add(new N(a[p], p));
			q.addAll(k);
			p--;
		}
		return -1;
	}

	class N implements Comparable<N> {
		int n, i;

		public N(int n, int i) {
			this.n = n;
			this.i = i;
		}

		public int compareTo(N w) {
			if (n == w.n)
				return w.i - i;
			return w.n - n;
		}
	}
}
