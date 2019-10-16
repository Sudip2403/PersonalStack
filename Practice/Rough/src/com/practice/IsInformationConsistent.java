package com.practice;

import java.util.Arrays;

public class IsInformationConsistent {

	public static void main(String[] args) {
		int[][] e = { { 0, 1, 0, 1 }, { -1, 1, 0, 0 }, { -1, 0, 0, 1 } };
		System.out.println(new IsInformationConsistent().isInformationConsistent(e));
	}

	boolean isInformationConsistent(int[][] e) {
		int[] d = new int[e[0].length];
		Arrays.fill(d, 2);
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				if (e[i][j] == 0)
					continue;
				else if (d[j] == 2)
					d[j] = e[i][j];
				else if (d[j] != e[i][j])
					return false;
			}
		}
		return true;
	}

}
