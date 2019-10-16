package com.practice;

public class SumAfterEvenNumberQueries {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
		int[] r = new SumAfterEvenNumberQueries().sumEvenAfterQueries(A, queries);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}

	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int evensum = 0, n = A.length, p = queries.length;
		int[] answers = new int[p];
		for (int i = 0; i < n; i++)
			if (A[i] % 2 == 0)
				evensum += A[i];
		for (int i = 0; i < p; i++) {
			int previousVal = A[queries[i][1]] % 2 == 0 ? A[queries[i][1]] : 0;
			A[queries[i][1]] += queries[i][0];
			evensum = evensum - previousVal + (A[queries[i][1]] % 2 == 0 ? A[queries[i][1]] : 0);
			answers[i] = evensum;
		}
		return answers;
	}
}
