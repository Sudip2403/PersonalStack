package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors1 {

	public static void main(String[] args) {
		int n = 142;
		Integer[] r = new PrimeFactors1().primeFactors(n);
		for (Integer integer : r) {
			System.out.print(integer + ", ");
		}
	}

	Integer[] primeFactors(int n) {
		int m = n;
		if (f(n))
			return new Integer[] { n };
		List<Integer> r = new ArrayList<>();
		for (int i = 2; i <= m / 2; i++) {
			if (f(i)) {
				while (n % i == 0) {
					r.add(i);
					n /= i;
				}
			}
		}
		return r.toArray(new Integer[r.size()]);
	}

	boolean f(int k) {
		for (int i = 2; i < k / 2; i++) {
			if (k % i == 0)
				return false;
		}
		return k == 1 ? false : true;
	}
}
