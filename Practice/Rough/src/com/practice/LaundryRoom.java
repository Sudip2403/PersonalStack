package com.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class LaundryRoom {

	public static void main(String[] args) {
		int w = 2, d = 2;
		String[] a = { "1:00", "1:15", "1:15" };
		System.out.println(new LaundryRoom().laundryRoom(w, d, a));
	}

	String laundryRoom(int w, int d, String[] a) {
		Queue<String> wq = new PriorityQueue<>();
		Queue<String> dq = new PriorityQueue<>();
		String e = "";
		for (int i = 0; i < a.length; i++) {
			if (w > 0) {
				wq.add(f(a[i], 30));
				w--;
			} else if (!wq.isEmpty()) {
				String t = wq.poll();
				t = f(t(t) > t(a[i]) ? t : a[i], 30);
				wq.add(t);
				if (d > 0) {
					dq.add(f(t, 40));
					d--;
				} else {
					String r = dq.poll();
					dq.add(f(r, 40));
				}
			}
		}
		while (!dq.isEmpty())
			e = dq.poll();
		while (!wq.isEmpty())
			e = f(wq.poll(), 40);
		return e;
	}

	String f(String t, int p) {
		long d = t(t) + p;
		return (d / 60) + ":" + (d % 60);
	}

	long t(String t) {
		return Long.parseLong(t.substring(0, t.indexOf(":"))) * 60
				+ Long.parseLong(t.substring(t.indexOf(":") + 1, t.length()));
	}

}
