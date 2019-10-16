package com.practice;

public class SnailSort {

	public static void main(String[] args) {
		// int[][] array = { { 1, 2, 3, 1 }, { 4, 5, 6, 4 }, { 7, 8, 9, 7 }, {
		// 7, 8, 9, 7 } };
		//int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		//int[][] array = { { 5, 2 }, { 3, 5} };
		
		/*int[][] array = { 	{4, 5, 3, 7, 2, 5},
							{7, 3, 2, 8, 4, 3},
							{0, 8, 6, 5, 7, 0},
							{6, 5, 6, 9, 4, 7},
							{9, 1, 4, 1, 3, 4},
							{9, 2, 7, 4, 8, 7} };*/
		
		int[][] array = {{}};
		int[] r = snail(array);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}

	public static int[] snail(int[][] array) {
		int n = array.length, m = n * n;
		 if(n <= 0 || (n == 1 && array[0].length == 0))
		    return new int[]{};
		int k = 0, sx = 0, ex = n - 1, sy = 0, ey = n - 1, i = 0;
		int[] r = new int[m];
		while (k < m) {
			if (k < m)
				k = right(array, r, k, m, sx + i, sy + i, ey - i);
			if (k < m)
				k = down(array, r, k, m, sx + i + 1, ex - i, ey - i);
			if (k < m)
				k = left(array, r, k, m, ex - i, ey - i - 1, sy + i);
			if (k < m)
				k = up(array, r, k, m, ex - i - 1, sx + i + 1, sy + i);
			i++;
		}
		return r;
	}

	static int right(int[][] arr, int[] r, int k, int m, int x, int sy, int ey) {
		for (int i = sy; i <= ey & k < m; i++)
			r[k++] = arr[x][i];
		return k;
	}

	static int left(int[][] arr, int[] r, int k, int m, int x, int sy, int ey) {
		for (int i = sy; i >= ey & k < m; i--)
			r[k++] = arr[x][i];
		return k;
	}

	static int up(int[][] arr, int[] r, int k, int m, int sx, int ex, int y) {
		for (int i = sx; i >= ex & k < m; i--)
			r[k++] = arr[i][y];
		return k;
	}

	static int down(int[][] arr, int[] r, int k, int m, int sx, int ex, int y) {
		for (int i = sx; i <= ex & k < m; i++)
			r[k++] = arr[i][y];
		return k;
	}
}