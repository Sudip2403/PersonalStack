package com.sort;

public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] a = new int[] { 6, 10, 13, 5, 8, 3, 2, 11 };
		is.printArray(a);
		is.insertionSort(a);
		is.printArray(a);
	}

	public void insertionSort(int[] a) {
		 for(int j = 1; j < a.length; j++) { 			
			int key = a[j]; 			
			int i = j - 1; 			
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i = i - 1;
			}
			a[i + 1] = key;
		}

	}

	public void printArray(int[] a) {
		 for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
}
