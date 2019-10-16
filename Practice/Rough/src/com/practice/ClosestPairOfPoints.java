package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestPairOfPoints {

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(
				new Point(0.014935, 0.056654),
				new Point(0.037448, 0.055521),
				new Point(0.042574, 0.034512),
				new Point(0.037977, 0.046301),
				new Point(0.043493, 0.056079),
				new Point(0.042260, 0.072777),
				new Point(0.045641, 0.065008),
				new Point(0.024069, 0.072401),
				new Point(0.050922, 0.037566),
				new Point(0.005444, 0.064584),
				new Point(0.013866, 0.030277),
				new Point(0.022271, 0.038566),
				new Point(0.035389, 0.061661),
				new Point(0.023231, 0.029903),
				new Point(0.025158, 0.059535),
				new Point(0.015635, 0.051284),
				new Point(0.033531, 0.073043),
				new Point(0.008857, 0.050831),
				new Point(0.016319, 0.066932),
				new Point(0.028904, 0.049817),
				new Point(0.045612, 0.044574),
				new Point(0.029617, 0.031110),
				new Point(0.026929, 0.041774),
				new Point(0.010474, 0.049172),
				new Point(0.007547, 0.055995),
				new Point(0.009104, 0.038907)
		);
		List<Point> r = closestPair(points);
		for (Point point : r) {
			System.out.println(point.toString());
		}
	}
	
	public static List<Point> closestPair(List<Point> points) {
		double min = Double.MAX_VALUE;
		Point p = null, q = null;
		int n = points.size();
		Collections.sort(points, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return ((Double) a.x).compareTo((Double) b.x);
			}
		});
		for (int i = 1; i < n; i++) {
			Point g = points.get(i), h = points.get(i - 1);
			double d = Math.sqrt((g.x - h.x) * (g.x - h.x) + (g.y - h.y) * (g.y - h.y));
			if (d < min) {
				min = d;
				p = new Point(g.x, g.y);
				q = new Point(h.x, h.y);
			}
		}

		Collections.sort(points, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return ((Double) a.y).compareTo((Double) b.y);
			}
		});
		for (int i = 1; i < n; i++) {
			Point g = points.get(i), h = points.get(i - 1);
			double d = Math.sqrt((g.x - h.x) * (g.x - h.x) + (g.y - h.y) * (g.y - h.y));
			if (d < min) {
				min = d;
				p = new Point(g.x, g.y);
				q = new Point(h.x, h.y);
			}
		}
		return Arrays.asList(new Point[] { p, q });
	}

	static class Point {
		public double x, y;

		public Point() {
			x = y = 0.0;
		}

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return String.format("(%f, %f)", x, y);
		}

		@Override
		public int hashCode() {
			return Double.hashCode(x) ^ Double.hashCode(y);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point other = (Point) obj;
				return x == other.x && y == other.y;
			} else {
				return false;
			}
		}
	}
}
