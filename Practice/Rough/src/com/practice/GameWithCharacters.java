package com.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class GameWithCharacters {

	public static void main(String[] args) {
		int n = 50;
		String s = "aaorvdaxzvucqunaxsodmvydflnkstcxgjbfgfqbftkcojnaaa";
		String[] r = new GameWithCharacters().gameWithCharacters(n, s);
		System.out.println(r[0] + ", " + r[1]);
	}

	String[] gameWithCharacters(int n, String s) {
		String l = "", b = "";
		char[] c = s.toCharArray();
		Queue<L> q = new PriorityQueue<>();
		boolean[] f = new boolean[n];
		for (int i = 0; i < n; i++)
			q.add(new L(s.charAt(i), i));
		int i = n - 1, y = 0;
		while (true) {
			while (i >= 0 && f[i])
				i--;
			if (i >= 0) {
				l += c[i];
				f[i] = true;
				y++;
			}
			if (!q.isEmpty()) {
				int j = -1;
				while (((j > -1 && f[j]) || j == -1) && !q.isEmpty())
					j = q.poll().i;
				if (j > -1) {
					b += c[j];
					f[j] = true;
					y++;
				}
			}
			//System.out.println("lily:" + l + " bob:" + b);
			if (y == n)
				break;
		}
		if (l.compareTo(b) < 0)
			return new String[] { "Lily", l };
		if (l.compareTo(b) > 0)
			return new String[] { "Bob", b };
		return new String[] { "Lily", l };
	}

	class L implements Comparable<L> {
		char c;
		int i;

		public L(char c, int i) {
			super();
			this.c = c;
			this.i = i;
		}

		public int compareTo(L o) {
			if (o.c == this.c)
				return o.i - i;
			return this.c - o.c;
		}
	}

}
