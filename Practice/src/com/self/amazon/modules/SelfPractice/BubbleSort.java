package com.self.amazon.modules.SelfPractice;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[]{6, 10, 13, 5, 8, 3, 2, 11};
		bubbleSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void bubbleSort(int[] arr){
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length -i -1; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
}
