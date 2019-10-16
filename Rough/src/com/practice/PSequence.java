package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a int[] S containing a set of distinct integers. A sequence is called a p-sequence of S if it satisfies both of the following conditions:



1. It contains each element of S exactly once.

2. For each pair of consecutive sequence elements s1 and s2, (s1 - s2) is not divisible by p.



Return the number of p-sequences of S, modulo 1234567891.
 
Definition
    	
Class:	PSequence
Method:	count
Parameters:	int[], int
Returns:	int
Method signature:	int count(int[] S, int p)
(be sure your method is public)
    
 
Constraints
-	S will contain between 1 and 30 elements, inclusive.
-	All elements of S will be distinct.
-	Each element of S will be between -1,000,000 and 1,000,000, inclusive.
-	p will be between 1 and 1,000, inclusive.
 
Examples
0)	
    	
{-1,0,1,2,3}
10
Returns: 120
All permutations of numbers are valid, so we have 5! = 120 sequences.
1)	
    	
{6,2}
4
Returns: 0
Both numbers have the same remainder modulo 4 and so we cannot create a valid 4-sequence from them.
2)	
    	
{1,2,3,4}
3
Returns: 12
3)	
    	
{4,6,8,-3,7}
2
Returns: 12

 */
public class PSequence {
	
	public static void main(String[] args) {
		System.out.println(count(new int[]{4,6,8,-3,7}, 2));
	}
	
	static int count(int[] S, int p){
		Integer[] arr = new Integer[S.length];
		for (int i = 0; i < S.length; i++) {
			arr[i] = S[i];
		}
		
		List<List<Integer>> list = permute(arr, p);
		int c = 0;
		
		for (List<Integer> list2 : list) {
			if(isPSeq(list2, p))
				c++;
		}
		
		return c;
	}

	
	static List<List<Integer>> permute(Integer[] S, int p){
		if(S == null){
			return new ArrayList<List<Integer>>();
		}
		if(S.length == 1){
			List<List<Integer>> li = new ArrayList<>();
			List<Integer> list = new ArrayList<Integer>();
			list.add(S[0]);
			li.add(list);
			return li;
		}
		
		int head = S[0];
		Integer[] rem = Arrays.asList(S).subList(1, S.length).toArray(new Integer[S.length-1]);
		
		List<List<Integer>> res = permute(rem, p);
		
		List<List<Integer>> li2 = new ArrayList<>();
		for (List<Integer> list : res) {
			for (int i = 0; i <= list.size(); i++) {
				List<Integer> lis = new ArrayList<Integer>();
				lis.addAll(list);
				lis.add(i, head);
				li2.add(lis);
			}
		}
		return li2;
	}
	
	static boolean isPSeq(List<Integer> arr, int p){
		boolean f = true;
		
		for (int i = 1; i < arr.size(); i++) {
			if((arr.get(i-1) - arr.get(i))%p == 0){
				f = false;
				break;
			}
		}
		return f;
	}
}












