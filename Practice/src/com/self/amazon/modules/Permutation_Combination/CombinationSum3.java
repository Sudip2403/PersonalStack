package com.self.amazon.modules.Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		CombinationSum3 combinationSum3 = new CombinationSum3();
		List<List<Integer>> list = combinationSum3.combinationSum3(3, 9);
		
		System.out.println(list);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> list = new ArrayList<Integer>();
	    dfs(result, 1, n, list, k);
	    return result;
	}
	 
	public void dfs(List<List<Integer>> result, int start, int sum, List<Integer> list, int k){
	    if(sum==0 && list.size()==k){
	        List<Integer> temp = new ArrayList<Integer>();
	        temp.addAll(list);
	        result.add(temp);
	    }
	 
	    for(int i=start; i<=9; i++){
	        if(sum-i<0) break;
	        if(list.size()>k) break;
	 
	        list.add(i);
	        dfs(result, i+1, sum-i, list, k);
	        list.remove(list.size()-1);
	    }
	}
}
