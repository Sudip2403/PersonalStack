package com.self.amazon.modules.SelfPractice.whitePaper;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort{
	
	public static void main(String[] args){
		Integer[] arr = new Integer[]{12, 4, 5, 1, 3, 7, 11};
		Integer[] arrS = sort(arr);
		
		for(int i=0; i < arrS.length; i++){
			System.out.print(arrS[i] + " ");
		}
	}
	
	private static Integer[] sort(Integer[] arr){
		
		if(arr == null || arr.length <= 1) return arr;
	
		int p = 0;
		int j = 0;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[p]){
				j++;
				swap(arr, i, j);			
			}
		}
		swap(arr, p, j);
		
		Integer[] a = new Integer[j];
		a = Arrays.asList(arr).subList(0, j).toArray(a);
		
		Integer[] b = new Integer[arr.length - (j + 1)];
		b = Arrays.asList(arr).subList(j + 1, arr.length).toArray(b);
		
		List<Integer> aML = new ArrayList<Integer>();
		aML.addAll(Arrays.asList(sort(a)));
		aML.add(arr[j]);
		aML.addAll(Arrays.asList(sort(b)));
		
		Integer[] arrM = new Integer[aML.size()];
		arrM = aML.toArray(arrM);
		
		return arrM;
		
	}
	
	private static void swap(Integer[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}