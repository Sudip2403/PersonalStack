package com.amazon;

import java.util.Arrays;

/**
 * With the best time complexity, please come up with a code to find the minimum delta of two elements 
 * from two different arrays of integers of different sizes - a[-3, 1, 999], b[-1, 2, 3] 


Edit: Please dont forget the min delta can also be from b-a not just a-b
 */
public class MinDeltaOf2Arrays {

	

	public static void main(String[] args) {
		Integer[] r = sort(new Integer[]{3,1,2,4,0});
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		
		/*Integer[] a = new Integer[]{-3,1,999};
		Integer[] b = new Integer[]{-1,2,3};
		System.out.println(minDelta(a, b));*/
		
	}
	
	static int minDelta(Integer[] arr1, Integer[] arr2){
		Integer[] a = sort(arr1);
		Integer[] b = sort(arr2);
		
		Integer[] c = new Integer[a.length + b.length];
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int p = 0;
		
		while(i < arr1.length || j < arr2.length){
			if(i < a.length && j < b.length && a[i] < b[j]){
				c[p] = a[i];
				i++;
			}else if(i < a.length && j < b.length && a[i] >= b[j]){
				c[p] = b[j];
				j++;
			}else if(i < a.length){
				c[p] = a[i];
				i++;
			}else if(j < b.length){
				c[p] = b[j];
				j++;
			}
			if(p > 0)
				min = Math.min(min, Math.min(c[p]-c[p-1], c[p-1]-c[p]));
			p++;
		}
		
		return min;
		
	}
	
	static Integer[] sort(Integer[] arr){
		if(null == arr) return null;
		if(arr.length == 1) return arr;
		
		int pivot = 0;
		int swapIndex = 0;
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[pivot]){
				swapIndex++;
				swap(arr, i, swapIndex);			
			}
		}
		
		swap(arr, pivot, swapIndex);
		
		Integer[] a = sort(Arrays.asList(arr).subList(0, swapIndex+1).toArray(new Integer[swapIndex+1]));
		Integer[] b = sort(Arrays.asList(arr).subList(swapIndex+1, arr.length).toArray(new Integer[arr.length - swapIndex-1]));
		
		
		Integer[] res = new Integer[arr.length];
		if(null != a){
			for (int i = 0; i < a.length; i++) {
				res[i] = a[i];
			}
		}
		if(null != b){
			for (int i = 0; i < b.length; i++) {
				res[a.length + i] = b[i];
			}
		}
		return res;
	}
	
	static void swap(Integer[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
}
