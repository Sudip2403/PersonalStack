package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Using the operators '+', '-', '/', '*', and parentheses as many times as you wish, find expressions for the smallest and largest primes that use each element of values exactly once. A prime is an integer greater than 1 with no divisors except 1 and itself. Return a int[] with exactly two elements, where the first element is the smallest prime you can make, and the second is the largest. If no primes can be constructed, return an empty int[].
 
Definition
    	
Class:	MixedUpPrimes
Method:	findPrimes
Parameters:	int[]
Returns:	int[]
Method signature:	int[] findPrimes(int[] values)
(be sure your method is public)
    
 
Notes
-	The division operator truncates its results. For example, 8/5 = 1.
-	The given numbers cannot be concatenated. For example, 8 and 5 cannot be combined to form 85.
 
Constraints
-	values will contain between 1 and 6 elements, inclusive.
-	Each element of values will be between 1 and 30, inclusive.
 
Examples
0)	
    	
{1,2}
Returns: {2, 3 }
We get 2 using 2*1. We get 3 using 2+1.
1)	
    	
{1,2,3}
Returns: {2, 7 }
Here we use 3-2+1=2 and 3*2+1 = 7.
2)	
    	
{1,2,3,4,5,6}
Returns: {2, 719 }
3)	
    	
{2,3,5,7,11,13}
Returns: {2, 15017 }
4)	
    	
{2,2,2,2,2,2}
Returns: {2, 17 }
5)	
    	
{8}
Returns: { }

 */
public class MixedUpPrimes {

	public static void main(String[] args) {
		int[] a = findPrimes(new Integer[]{2,2,2,2,2,2});
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	static int[] findPrimes(Integer[] values){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		List<List<Integer>> list = permute(values);
		
		for (List<Integer> list2 : list) {
			List<Integer> l = calc(list2.toArray(new Integer[list2.size()]), new ArrayList<>(), 0, 1, 0);
			Collections.sort(l, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			for (Integer i : l) {
				if(isPrime(i)){
					min = Math.min(min, i);
					max = Math.max(max, i);
				}
			}
		}
		
		int[] ret = new int[2];
		ret[0] = min;
		ret[1] = max;
		return ret;
	}
	
	static List<List<Integer>> permute(Integer[] arr){
		if(null == arr) return new ArrayList<>();
		if(arr.length == 1){
			List<List<Integer>> li = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			list.add(arr[0]);
			li.add(list);
			return li;
		}
		
		int head = arr[0];
		Integer[] rem = Arrays.asList(arr).subList(1, arr.length).toArray(new Integer[arr.length-1]);
		
		List<List<Integer>> res = permute(rem);
		
		List<List<Integer>> li = new ArrayList<>();
		for (List<Integer> list : res) {
			for (int i = 0; i <= list.size(); i++) {
				List<Integer> l = new ArrayList<>();
				l.addAll(list);
				l.add(i, head);
				li.add(l);
			}
		}
		return li;
	}
	
	static List<Integer> calc(Integer[] arr, List<Integer> list, int i, int j, int val){
		if(j == arr.length){
			list.add(Math.abs(val));
			return list;
		}else{
			if(i == 0 && j == 1){
				list = calc(arr, list, i+1, j+1, arr[i] + arr[j]);
				list = calc(arr, list, i+1, j+1, arr[i] / arr[j]);
				list = calc(arr, list, i+1, j+1, arr[i] * arr[j]);
				list = calc(arr, list, i+1, j+1, arr[i] - arr[j]);
			}else{
				list = calc(arr, list, i+1, j+1, val + arr[j]);
				list = calc(arr, list, i+1, j+1, val / arr[j]);
				list = calc(arr, list, i+1, j+1, val * arr[j]);
				list = calc(arr, list, i+1, j+1, val - arr[j]);
			}
		}
		return list;	
	}
	
	static boolean isPrime(int val){
		if(val == 0 || val == 1) return false;
		for (int i = 2; i < val/2; i++) {
			if(val % i == 0) return false;
		}
		return true;
	}
	
}














