package com.practice;

import java.util.Arrays;

public class PrimeArrangements {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(new PrimeArrangements().numPrimeArrangements(n));
	}

	int MOD = 1000000007;

	public int numPrimeArrangements(int n) {
		int primes = countPrimes(n);
		long permutePrimes = permute(primes);
		long permuteNonPrimes = permute(n - primes);
		return (int) ((permutePrimes * permuteNonPrimes) % MOD);
	}

	long permute(int n) {
		long k = 1, r = 1;
		while (r <= n) {
			k = (k * r) % MOD;
			r++;
		}
		return k;
	}

	int countPrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int i = 2; i * i <= n + 1; i++) {
			if (prime[i]) {
				int k = 2;
				while (i * k <= n) {
					prime[i * k] = false;
					k++;
				}
			}
		}
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result += prime[i] ? 1 : 0;
		}
		return result;
	}

}
