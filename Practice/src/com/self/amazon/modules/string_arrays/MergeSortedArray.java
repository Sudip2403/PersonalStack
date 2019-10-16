package com.self.amazon.modules.string_arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		merge(new int[] { 1, 8, 9, 15 }, 4, new int[] { 4, 6, 10, 20 }, 4);

	}

	public static void merge(int A[], int m, int B[], int n) {

		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}

		while (n > 0) {
			A[m + n - 1] = B[n - 1];
			n--;
		}
	}
}
