package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ASeries {

	public static void main(String[] args) {
		int[] values = { -10,-20,-10,-10 };
		System.out.println(new ASeries().longest(values));
	}

	public int longest(int[] values) {
		int n = values.length;
		Set<T>[] dp = new HashSet[n];
		Arrays.sort(values);
		dp[0] = new HashSet<>();
		dp[0].add(new T(0, 1));
		for (int i = 1; i < n; i++) {
			Set<T> set = new HashSet<>();
			for (int k = i - 1; k >= 0; k--) {
				for (T t : dp[k]) {
					if (values[i] - values[k] == t.d) {
						set.add(new T(t.d, t.l + 1));
					} else {
						set.add(new T(values[i] - values[k], 2));
					}
				}
			}
			dp[i] = new HashSet<>(set);
		}
		int r = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (T t : dp[i]) {
				r = Math.max(r, t.l);
			}
		}
		return r;
	}

	static class T {
		int d, l;

		public T(int d, int l) {
			super();
			this.d = d;
			this.l = l;
		}
		
		@Override
		public boolean equals(Object anObject){
			T t = (T)(anObject);
			return t.d == d;
		}
		
		@Override
		public int hashCode(){
			return d;
		}
		
		@Override
		public String toString(){
			return d + "->" + l;
		}
	}

}
