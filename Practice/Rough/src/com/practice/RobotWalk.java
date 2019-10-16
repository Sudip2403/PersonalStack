package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotWalk {

	public static void main(String[] args) {
		int[] a = { 100000, 100000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000};
		System.out.println(new RobotWalk().robotWalk(a));
	}

	int x = 0, y = 0, xmax = 0, xmin = 0, ymax = 0, ymin = 0;
	Map<Integer, List<P>> xm = new HashMap<>();
	Map<Integer, List<P>> ym = new HashMap<>();

	boolean robotWalk(int[] a) {
		int n = a.length, i = 0;
		if (n < 4)
			return false;
		while (i < n) {
			if (i < n) {
				if (c(x, x, y + 1, y + a[i]))
					return true;
				List<P> p = xm.get(x);
				if (p == null)
					p = new ArrayList<>();
				p.add(new P(y, y + a[i]));
				xm.put(x, p);
				y += a[i];
				m(x, y);
				i++;
			}
			if (i < n) {
				if (c(x + 1, x + a[i], y, y))
					return true;
				List<P> p = ym.get(y);
				if (p == null)
					p = new ArrayList<>();
				p.add(new P(x, x + a[i]));
				ym.put(y, p);
				x += a[i];
				m(x, y);
				i++;
			}
			if (i < n) {
				if (c(x, x, y - a[i], y - 1))
					return true;
				List<P> p = xm.get(x);
				if (p == null)
					p = new ArrayList<>();
				p.add(new P(y - a[i], y));
				xm.put(x, p);
				y -= a[i];
				m(x, y);
				i++;
			}
			if (i < n) {
				if (c(x - a[i], x - 1, y, y))
					return true;
				List<P> p = ym.get(y);
				if (p == null)
					p = new ArrayList<>();
				p.add(new P(x - a[i], x));
				ym.put(y, p);
				x -= a[i];
				m(x, y);
				i++;
			}
		}
		return false;
	}

	boolean c(int xl, int xh, int yl, int yh) {
		P p = f(xl, xh, yl, yh);
		if (p != null) {
			int f = p.l, g = p.h;
			while (f >= xmin && g >= ymin && f <= xmax && g <= ymax) {
				int l = (int) Math.sqrt((x - f) * (x - f) + (y - g) * (y - g));
				if (f(f, f, g, g + l) != null && f(f, f + l, g, g) != null)
					return true;
				f--;
				g--;
			}
			f = p.l;
			g = p.h;
			while (f >= xmin && g >= ymin && f <= xmax && g <= ymax) {
				int l = (int) Math.sqrt((x - f) * (x - f) + (y - g) * (y - g));
				if (f(f, f, g, g + l) != null && f(f - l, f, g, g) != null)
					return true;
				f++;
				g--;
			}
			f = p.l;
			g = p.h;
			while (f >= xmin && g >= ymin && f <= xmax && g <= ymax) {
				int l = (int) Math.sqrt((x - f) * (x - f) + (y - g) * (y - g));
				if (f(f, f, g - l, g) != null && f(f - l, f, g, g) != null)
					return true;
				f++;
				g++;
			}
			f = p.l;
			g = p.h;
			while (f >= xmin && g >= ymin && f <= xmax && g <= ymax) {
				int l = (int) Math.sqrt((x - f) * (x - f) + (y - g) * (y - g));
				if (f(f, f, g - l, g) != null && f(f, f + l, g, g) != null)
					return true;
				f--;
				g++;
			}
		}
		return false;
	}

	P f(int xl, int xh, int yl, int yh) {
		if (xl != xh) {
			for (Map.Entry<Integer, List<P>> i : xm.entrySet()) {
				int k = i.getKey();
				if (k >= xl && k <= xh) {
					for (P e : i.getValue()) {
						if (yl >= e.l && yl <= e.h)
							return new P(k, yl);
					}
				}
			}
		} else if (yl != yh) {
			for (Map.Entry<Integer, List<P>> i : ym.entrySet()) {
				int k = i.getKey();
				if (k >= yl && k <= yh) {
					for (P e : i.getValue()) {
						if (xl >= e.l && xl <= e.h)
							return new P(xl, k);
					}
				}
			}
		}
		return null;
	}

	void m(int x, int y) {
		xmin = Math.min(xmin, x);
		xmax = Math.max(xmax, x);
		ymin = Math.min(ymin, y);
		ymax = Math.max(ymax, y);
	}

	class P {
		int l, h;

		public P(int l, int h) {
			this.l = l;
			this.h = h;
		}

		public String toString() {
			return l + ", " + h;
		}
	}
}
