package com.practice;

public class FrequencyInSortedArray {
	
	public static void main(String[] args) {
		int a[] = {1, 1, 2, 3, 3, 3, 3, 4, 4 , 4, 5};
		
		int higherIndex = getHigherIndex(a, 4, 0, 10, false);
		//int lowerIndex = getIndex(a, 1, 0, 10, true) + 1;
		
		//System.out.println("Occurance  - " + (higherIndex - lowerIndex + 1));
	}
	
	private static int getHigherIndex(int a[], int toSearch, int start, int end, boolean islowerIndex){
		int mid = 0;
		
		while(start < end){
			mid = (start + end)/2;

			if(!islowerIndex){
				if(a[mid] <= toSearch){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}else{
				if(a[mid] < toSearch){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		
		return mid;
	}

}
