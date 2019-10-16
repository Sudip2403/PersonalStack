package com.practice;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 5, 1, 2, 7 };
		heapsort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	// 5,1,2,7
	static void heapsort(int[] arr) {
		int n = arr.length;
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, i, n);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, 0, i);
		}
	}

	// bring max to the front
	static void heapify(int[] a, int i, int n) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && a[left] > a[largest])
			largest = left;
		if (right < n && a[right] > a[largest])
			largest = right;
		if (largest != i) {
			int t = a[largest];
			a[largest] = a[i];
			a[i] = t;
			heapify(a, largest, n);
		}
	}
}
