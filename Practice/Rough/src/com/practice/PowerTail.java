package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PowerTail {

	public static void main(String[] args) {
		int n = 999999997, p = 999999992;
		System.out.println(new PowerTail().PowerTail(n, p));
	}

	int PowerTail(int n, int p) {
		if (p == 0)
			return n == 0 ? -1 : 1;
		List<Integer> c = new ArrayList<>();
		long l = n % 10, h = 0;
		while (!c.contains((int)l)) {
			c.add((int) l);
			long t = (n * l);
			l = (int) (t % 10);
			h++;
		}
		return c.get((int) ((p - 1) % h));
	}

}
