package com.self.amazon.modules.SelfPractice;

public class InsertionSort {

	
	public static void main(String[] args) {
		int[] arr = new int[]{6, 10, 13, 5, 8, 3, 2, 11};
		insertionSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void insertionSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j-1] > arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
}
