package com.self.amazon.modules.Permutation_Combination;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	
	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();
		ArrayList<ArrayList<Integer>> list = combinationSum.combinationSum(new int[]{2, 3, 6, 5, 7}, 7);
		
		System.out.println(list);
	}
	
	
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
	    if(candidates == null || candidates.length == 0) return result;
	 
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	 
	    combinationSum(candidates, target, 0, current, result);
	 
	    return result;
	}
	 
	public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
	   if(target == 0){
	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
	       result.add(temp);
	       return;
	   }
	 
	   for(int i=j; i<candidates.length; i++){
	       if(target < candidates[i]) 
	            return;
	 
	       curr.add(candidates[i]);
	       //generate combination with non-unique numbers
	       combinationSum(candidates, target - candidates[i], i, curr, result);
	       
	       //generate combination with unique numbers
	       //combinationSum(candidates, target - candidates[i], i + 1, curr, result);
	       
	       curr.remove(curr.size()-1); 
	   }
	}
}
