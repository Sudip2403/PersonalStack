package com.self.amazon.modules.SelfPractice;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[]{6, 10, 13, 5, 8, 3, 2, 11};
		selectionSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void selectionSort(int[] arr){

		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				min = arr[min] < arr[j] ? min : j; 
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
