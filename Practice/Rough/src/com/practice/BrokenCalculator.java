package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BrokenCalculator {

	public static void main(String[] args) {
		int X = 1, Y = 1000000000;
		System.out.println(new BrokenCalculator().brokenCalc(X, Y));
	}

	public int brokenCalc(int X, int Y) {
		int d = 0;
		Stack<Integer> q = new Stack<>();
		q.add(X);
		Map<Integer, Boolean> m = new HashMap<>();
		while (true) {
			Stack<Integer> p = new Stack<>();
			while (!q.isEmpty()) {
				Integer e = q.pop();
				if (e == Y)
					return d;
				if (!m.containsKey(e - 1) && e - 1 > 0) {
					p.add(e - 1);
					m.put(e - 1, true);
				}
				if (!m.containsKey(e << 1) && e < Y && (e << 1) > 0) {
					p.add(e << 1);
					m.put(e << 1, true);
				}
			}
			d++;
			q.addAll(p);
		}
	}
}
