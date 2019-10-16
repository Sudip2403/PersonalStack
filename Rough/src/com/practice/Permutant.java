package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hero likes combinatorics. He is especially fond of complicated formulas related to permutations. Hero has a int[] a containing n (not necessarily distinct) positive integers. The sum of these integers is m.
There are n! permutations of the array a. For each of these permutations, Hero does the following computation:

Let b be the permuted array a.
Let s be the array of prefix sums of the array b. That is, for each i, s[i] is the sum of the first i elements of b.
Hero computes the value m! / (s[2] * s[3] * ... * s[n]). Note that the product in the denominator starts with s[2], not s[1].
For example, suppose that b = {3,1,2}. This means that m = 3+1+2 = 6. The relevant prefix sums are s[2] = 3+1 = 4 and s[3] = 3+1+2 = 6. The value Hero computes is 6! / (4 * 6) = 30.

At the end, Hero will have n! values (one for each possible permutation of a). Let X be the sum of all those values. Help him by computing and returning the value (X modulo 1,000,000,007).
 
Definition
    	
Class:	Permutant
Method:	counthis
Parameters:	int[]
Returns:	int
Method signature:	int counthis(int[] a)
(be sure your method is public)
    
 
Notes
-	It can easily be shown that each of the n! values computed by Hero is a positive integer.
 
Constraints
-	Number of elements in a will be between 1 and 50, inclusive.
-	Each element in a will be between 1 and 50, inclusive.
-	Sum of elements in a will be between 1 and 1000, inclusive.
 
Examples
0)	
    	
{1,1}
Returns: 2
For the given a we have n = 2 and m = 1+1 = 2. There are n! = 2 permutations of a. For each of them, we have b = {1,1}, s[2] = 2, and thus Hero computes the value 2! / 2 = 1. The sum of all computed values is X = 1 + 1 = 2.
1)	
    	
{1,2}
Returns: 4
2)	
    	
{1,2,3}
Returns: 188
The six permutations of a give us the following six values computed by Hero: 24, 24, 30, 30, 40, and 40.
3)	
    	
{1,1,1,1,1}
Returns: 120
4)	
    	
{1,2,2,3,3,3,4,4,4,4}
Returns: 860993751

 */
public class Permutant {

	public static void main(String[] args) {
		System.out.println(counthis(new int[]	
				{1,2,2,3,3,3,4,4,4,4}));
	}
	
	static int counthis(int[] a){
		Integer[] arr = new Integer[a.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a[i];
		}
		List<List<Integer>> p = permute(arr);
		
		long sum = 0;
		for (List<Integer> list : p) {
			long s = list.get(0);
			long[] ac = new long[list.size()-1];
			for (int i = 1; i < list.size(); i++) {
				s += list.get(i);
				ac[i-1] = s;
			}
			
			long mul = 1;
			for (int i = 0; i < ac.length; i++) {
				mul *= ac[i];
			}
	
			long fac = 1;
			for (int i = 2; i <= s; i++) {
				fac *= i;
			}
			sum += fac/mul;
		}
		
		return (int)sum % 1000000007;
	}
	
	
	
	static List<List<Integer>> permute(Integer[] arr){
		if(null == arr) return new ArrayList<List<Integer>>();
		if(arr.length == 1){
			List<List<Integer>> l = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			list.add(arr[0]);
			l.add(list);
			return l;
		}
		
		int head = arr[0];
		Integer[] rem = Arrays.asList(arr).subList(1, arr.length).toArray(new Integer[arr.length-1]);
		
		List<List<Integer>> res = permute(rem);
		
		List<List<Integer>> ret = new ArrayList<>();
		for (List<Integer> list : res) {
			for (int i = 0; i <= list.size(); i++) {
				List<Integer> l = new ArrayList<>();
				l.addAll(list);
				l.add(i, head);
				ret.add(l);
			}
		}
		return ret;
	}
}








