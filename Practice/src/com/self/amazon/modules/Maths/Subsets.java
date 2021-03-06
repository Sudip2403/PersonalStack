package com.self.amazon.modules.Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = subsets(new int[]{1,2,3});
		
		System.out.println(list);
		
		
		ArrayList<ArrayList<Integer>> listWD = subsetsWithDup(new int[]{1,2,2});
		System.out.println(listWD);
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
	 
		//Arrays.sort(S);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	 
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
	 
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}
	 
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
	 
			result.addAll(temp);
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
	
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num == null)
			return null;
	 
		Arrays.sort(num);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = num.length-1; i >= 0; i--) {
	 
			//get existing sets
			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
	 
			//add current number to each element of the set
			for (ArrayList<Integer> temp : prev) {
				temp.add(0, num[i]);
			}
	 
			//add each single number as a set, only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}
	 
			//add all set created in this iteration
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
}
