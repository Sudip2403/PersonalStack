package com.self.amazon.modules.string_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetNumberUsingArrayListAndArithMeticOoperations {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.addAll(Arrays.asList(new Integer[]{1,2,3,4}));
		
		System.out.println(isReachable(arrayList, 21));
	}
	
	public static boolean isReachable(ArrayList<Integer> list, int target) {
		if (list == null || list.size() == 0)
			return false;
	 
		int i = 0;
		int j = list.size() - 1;
	 
		ArrayList<Integer> results = getResults(list, i, j, target);
	 
		for (int num : results) {
			if (num == target) {
				return true;
			}
		}
	 
		return false;
	}
	 
	public static ArrayList<Integer> getResults(ArrayList<Integer> list,
			int left, int right, int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	 
		if (left > right) {
			return result;
		} else if (left == right) {
			result.add(list.get(left));
			return result;
		}
	 
		for (int i = left; i < right; i++) {
	 
			ArrayList<Integer> result1 = getResults(list, left, i, target);
			ArrayList<Integer> result2 = getResults(list, i + 1, right, target);
	 
			for (int x : result1) {
				for (int y : result2) {
					result.add(x + y);
					result.add(x - y);
					result.add(x * y);
					if (y != 0)
						result.add(x / y);
				}
			}
		}
	 
		return result;
	}
}
