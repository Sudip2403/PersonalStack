package com.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class ZumaGame {

	public static void main(String[] args) {
		String board = "RBYYBBRRB";
		String hand = "YRBGB";
		System.out.println(new ZumaGame().findMinStep(board, hand));
	}

	public int findMinStep(String board, String hand) {
		char[] b = board.toCharArray();
		int[] alpha = new int[26];
		for (int i = 0; i < hand.length(); i++)
			alpha[hand.charAt(i) - 'A']++;

		int count = 0;
		Queue<Zuma> zuma = find(b);
		while (b.length > 0) {
			boolean found = false;
			zuma = find(b);
			while (b.length > 0 && !zuma.isEmpty()) {
				Zuma z = zuma.poll();
				if (alpha[z.c - 'A'] > 0) {
					alpha[z.c - 'A']--;
					b = squash(b, z.index, z.length);
					count++;
					found = true;
					break;
				}
			}
			if (!found)
				return -1;
		}
		return count;
	}

	Queue<Zuma> find(char[] b) {
		Queue<Zuma> queue = new PriorityQueue<>();
		int n = b.length, length = 1;
		char c = b[0];
		for (int i = 1; i < b.length; i++) {
			if (b[i] == c && length < 2)
				length++;
			else {
				queue.add(new Zuma(i - length, length, n, c));
				c = b[i];
				length = 1;
			}
		}
		queue.add(new Zuma(b.length - length, length, n, c));
		return queue;
	}

	char[] squash(char[] c, int p, int l) {
		char[] result = new char[c.length - l];
		for (int i = 0; i < p; i++)
			result[i] = c[i];
		for (int i = p + l; i < c.length; i++)
			result[i - l] = c[i];
		if (result.length < 3)
			return result;
		char t = result[0];
		int length = 1;
		for (int i = 1; i < result.length; i++) {
			if (result[i] == t)
				length++;
			else {
				if (length >= 3) {
					return squash(c, i - length, length);
				} else {
					t = result[i];
					length = 1;
				}
			}
		}
		if (length > 2)
			return squash(result, result.length - length, length);
		return result;
	}

	static class Zuma implements Comparable<Zuma> {
		int index, length, n;
		char c;

		public Zuma(int index, int length, int n, char c) {
			this.index = index;
			this.length = length;
			this.n = n;
			this.c = c;
		}

		public int compareTo(Zuma z) {
			if (this.length >= z.length
					&& Math.min(this.index - 0, n - this.index) > Math.min(z.index - 0, n - z.index))
				return -1;
			if (this.length > z.length && this.index > 0 && this.index + this.length < n
					&& Math.min(this.index - 0, n - this.index) < Math.min(z.index - 0, n - z.index))
				return -1;
			return 1;
		}
	}
}
