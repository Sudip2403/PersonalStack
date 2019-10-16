package com.practice;

import java.util.TreeMap;
import java.util.TreeSet;

public class Rough {

	public static void main(String[] args) {
		/*
		 * Integer[] i = { 1, 2, 4 }; int k = 5;
		 * System.out.println(Arrays.binarySearch(i, k));
		 * 
		 * Set<T> s = new HashSet<>(); s.add(new T(0, 0)); s.add(new T(0, 1));
		 * System.out.println();
		 * 
		 * System.out.println(Collections.binarySearch(Arrays.asList(new
		 * Integer[] { 1, 2, 3, 4, 4, 4, 4, 5 5, 8, 8, 8, 10, 19, 20}), 8));
		 */

		TreeMap<String, String> tm = new TreeMap<>();
		TreeSet<String> ts = new TreeSet<>();
		
		System.out.println(((Character)'↵').hashCode());
	}

	static class T {
		int d, l;

		public T(int d, int l) {
			super();
			this.d = d;
			this.l = l;
		}

		@Override
		public boolean equals(Object anObject) {
			T t = (T) (anObject);
			return t.d == d;
		}

		@Override
		public int hashCode() {
			return d;
		}

		@Override
		public String toString() {
			return d + "->" + l;
		}
	}

}
