package com.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachLastIndex {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 1, 4 };
		System.out.println(new ReachLastIndex().reachLastIndex(a));
	}

	boolean reachLastIndex(int[] a) {
		int t = a.length - 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (true) {
			Set<Integer> k = new HashSet<>();
			while (!q.isEmpty()) {
				int n = q.poll();
				if (n == t)
					return true;
				for (int i = 1; i <= a[n]; i++) {
					if (n + i <= t) {
						k.add(n + i);
					}
				}
			}
			if (k.isEmpty())
				return false;
			q.addAll(k);
		}
	}

}
