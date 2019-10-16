package com.self.amazon.modules.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RotateArray {

	public static void main(String[] args) {
		Integer[] arr = rotate(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	private static Integer[] rotate(Integer[] arr, int k){
		List<Integer> a = Arrays.asList(arr).subList(0, k);
		List<Integer> b = Arrays.asList(arr).subList(k, arr.length-1);		
		
		Collections.reverse(a);
		Collections.reverse(b);
		
		List<Integer> c = new ArrayList<Integer>(a);
		c.addAll(b);
		
		Collections.reverse(c);
		
		Integer[] ar = new Integer[c.size()];
		ar = c.toArray(ar);
		
		return ar;
	}
}
