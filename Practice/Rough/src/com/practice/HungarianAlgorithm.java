package com.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HungarianAlgorithm {

	public static void main(String[] args) {
		int[][] table = { { 1, 2 }, { 3, 4 } };
		System.out.println(new HungarianAlgorithm().hungarianAlgo(table));
	}

	/**
	 * Core of the algorithm (assuming square matrix):

For each row of the matrix, find the smallest element and subtract it from every element in its row.
Do the same (as step 1) for all columns.
Cover all zeros in the matrix using minimum number of horizontal and vertical lines.
Test for Optimality: If the minimum number of covering lines is n, an optimal assignment is possible and we are finished. Else if lines are lesser than n, we haven’t found the optimal assignment, and must proceed to step 5.
Determine the smallest entry not covered by any line. Subtract this entry from each uncovered row, and then add it to each covered column. Return to step 3.
Explanation for above simple example:

 
Below is the cost matrix of example given in above diagrams.
 2500  4000  3500
 4000  6000  3500
 2000  4000  2500

Step 1: Subtract minimum of every row.
2500, 4000 and 2000 are subtracted from rows 1, 2 and 
3 respectively.

   0   1500  1000
  500  2500   0
   0   2000  500

Step 2: Subtract minimum of every column.
0, 1500 and 0 are subtracted from columns 1, 2 and 3 
respectively.

   0    0   1000
  500  1000   0
   0   500  500

Step 3: Cover all zeroes with minimum number of 
horizontal and vertical lines.
example

Step 4:  Since we need 3 lines to cover all zeroes,
we have found the optimal assignment. 
 2500  4000  3500
 4000  6000  3500
 2000  4000  2500

So the optimal cost is 4000 + 3500 + 2000 = 9500
	 */
	
	int[][] table, tableOriginalValue;
	int n, m;
	boolean[] verticalRun, horizontalRun;

	int hungarianAlgo(int[][] table) {
		n = table.length;
		m = table[0].length;
		tableOriginalValue = new int[n][];
		for (int i = 0; i < n; i++)
			tableOriginalValue[i] = Arrays.copyOf(table[i], m);
		this.table = table;
		verticalRun = new boolean[n];
		horizontalRun = new boolean[m];

		initialRowZeros();
		initialColumnZeros();
		int v = optimalLines();
		if (v == n) {
			return allocateTask();
		}
		while (v < n) {
			findOptimal();
			v = optimalLines();
		}
		return allocateTask();
	}

	void initialRowZeros() {
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++)
				min = Math.min(min, table[i][j]);
			for (int j = 0; j < m; j++)
				table[i][j] -= min;
		}
	}

	void initialColumnZeros() {
		for (int i = 0; i < m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++)
				min = Math.min(min, table[j][i]);
			for (int j = 0; j < n; j++)
				table[j][i] -= min;
		}
	}

	int optimalLines() {
		PriorityQueue<P> p = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (table[i][j] == 0)
					p.add(new P(i, j));
			}
		}
		int lines = 0;
		while (!p.isEmpty()) {
			P q = p.poll();
			if (horizontalRun[q.i] || verticalRun[q.j])
				continue;
			lines++;
			horizontalRun[q.i] = true;
			verticalRun[q.j] = true;
		}
		return lines;
	}

	void findOptimal() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (verticalRun[i])
				continue;
			for (int j = 0; j < m; j++) {
				if (horizontalRun[j])
					continue;
				min = Math.min(min, table[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			if (verticalRun[i])
				continue;
			for (int j = 0; j < m; j++)
				table[i][j] -= min;
		}
		for (int i = 0; i < m; i++) {
			if (!horizontalRun[i])
				continue;
			for (int j = 0; j < n; j++)
				table[j][i] += min;
		}
	}

	int allocateTask() {
		PriorityQueue<D> p = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int t = 0, min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				if (table[i][j] == 0) {
					t++;
					min = Math.min(min, tableOriginalValue[i][j]);
				}
			}
			p.add(new D(i, t, min));
		}
		int total = 0;
		boolean[] tasks = new boolean[m];
		while (!p.isEmpty()) {
			D d = p.poll();
			for (int i = 0; i < m; i++) {
				if (table[d.index][i] == 0 && !tasks[i]) {
					total += tableOriginalValue[d.index][i];
					tasks[i] = true;
					break;
				}
			}
		}
		return total;
	}

	class P implements Comparable<P> {
		int i, j, r_zeros, c_zeros;

		public P(int i, int j) {
			super();
			this.i = i;
			this.j = j;
			for (int p = 0; p < m; p++) {
				if (table[i][p] == 0)
					this.r_zeros++;
			}
			for (int p = 0; p < n; p++) {
				if (table[p][j] == 0)
					this.c_zeros++;
			}
		}

		@Override
		public int compareTo(P p) {
			if (c_zeros + r_zeros - p.c_zeros - p.r_zeros != 0)
				return c_zeros + r_zeros - p.c_zeros - p.r_zeros;
			if (i < p.i)
				return -1;
			if (i > p.i)
				return 1;
			if (j < p.j)
				return -1;
			if (j > p.j)
				return 1;
			return 1;
		}
	}

	class D implements Comparable<D> {
		int index, taskCount, min;

		public D(int index, int taskCount, int min) {
			super();
			this.index = index;
			this.taskCount = taskCount;
			this.min = min;
		}

		@Override
		public int compareTo(D d) {
			if (taskCount < d.taskCount)
				return -1;
			if (taskCount > d.taskCount)
				return 1;
			if (min < d.min)
				return -1;
			if (min > d.min)
				return 1;
			return index - d.index;
		}
	}
}
