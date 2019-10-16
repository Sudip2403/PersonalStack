package com.practice;

public class SumOfSubArrayMins {

	public static void main(String[] args) {
		int[] A = { 81, 55, 2 };
		System.out.println(new SumOfSubArrayMins().sumSubarrayMins(A));
	}

	
	int M = 1000000007;
	public int sumSubarrayMins(int[] A) {
		int r = 0;
		for (int i = 0; i < A.length; i++)
			r += A[i] % M;
		for (int i = 2; i <= A.length; i++)
			r += f(A, i) % M;
		return r;
	}

	int f(int[] A, int k) {
		int r = 0;
		int p = 0, q = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			if (q > A[i]) {
				q = A[i];
				p = i;
			}
		}
		r += q % M;
		for (int i = 1; i <= A.length - k; i++) {
			if (!(p >= i && p < i + k)) {
				p = g(A, i, Math.min(A.length, i + k));
				q = A[p];
			} else if (A[i + k - 1] < q) {
				p = i;
				q = A[i + k - 1];
			}
			r += q % M;
		}
		return r;
	}

	int g(int[] A, int s, int e) {
		int p = 0, q = Integer.MAX_VALUE;
		for (int i = s; i < e; i++) {
			if (q > A[i]) {
				q = A[i];
				p = i;
			}
		}
		return p;
	}
}
