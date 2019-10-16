package com.practice;

public class RotateArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int k = 6;
		new RotateArray().rotate(a, k);
		System.out.println();
		rotLeft(a, k);
	}

	void rotate(int[] a, int k) {
		int n = a.length;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[(i + k) % n];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(b[i] + " ");
		}
	}

	static void rotLeft(int[] array, int n) {
		int[] rotatedArray = new int[array.length];
		for (int index = 0; index < array.length; index++) {
			int newPos = (index + (array.length - n)) % array.length;
			rotatedArray[newPos] = array[index];
		}
		for (int index = 0; index < array.length; index++) {
			System.out.print(rotatedArray[index] + " ");
		}
	}

}
