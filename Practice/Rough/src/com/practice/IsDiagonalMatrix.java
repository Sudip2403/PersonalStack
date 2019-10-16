package com.practice;

public class IsDiagonalMatrix {

	boolean isDiagonalMatrix(int[][] m) {
		int n = m.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (m[i][j] != 0)
					return false;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (m[i][j] != 0)
					return false;
			}
		}
		return true;
	}

}
