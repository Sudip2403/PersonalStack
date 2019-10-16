package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You have a group of non-zero digits, which are not necessarily unique. If you can insert '0' digits wherever you wish, there are an infinite number of integers which have exactly those non-zero digits. For example, given the group of digits {1, 2}, you can create the numbers 12, 21, 102, 120, 201, 210, 1002, 1020, etc. Given a potentially large number n in String format, return how many numbers that use the same exact non-zero digits are less than it. Leading zeros are not allowed.
 
Definition
    	
Class:	PermutationCounter
Method:	count
Parameters:	String
Returns:	long
Method signature:	long count(String n)
(be sure your method is public)
    
 
Constraints
-	n will have between 1 and 50 characters, inclusive.
-	n will consist only of digit characters ('0' - '9').
-	n will not start with a '0'.
-	There will be at most 2^63 - 1 integers with the same non-zero digits as n that are less than n
 
Examples
0)	
    	
"1020"
Returns: 7
From the problem statement above, we see that there are 7 values less than the given value.
1)	
    	
"50000000000000"
Returns: 13
Since there is only one non-zero digit in this number, the only way to increment the number is by inserting a zero after the 5. Therefore, the sequence is: 5, 50, 500, 5000, ..., 50000000000000.
2)	
    	
"1030000040000"
Returns: 1414
3)	
    	
"1901712530271201432987123"
Returns: 141588146596382454

 */
public class PermutationCounter {

	public static void main(String[] args) {
		System.out.println(count("50000000000000"));
	}
	
	static long count(String n){
		Set<String> lc = new HashSet<>();
		String wz = "0";
		for (int i = 0; i < n.length(); i++) {
			if(n.charAt(i) != '0')
				wz += n.charAt(i);
		}
		List<String> p = permute(wz);
		lc.addAll(p);
		List<String> ph = permute(n);
		for (String string : ph) {
			if(string.charAt(0) != '0' && Integer.parseInt(string) < Integer.parseInt(n))
				lc.add(string);
		}
		return lc.size();
	}
	
	static List<String> permute(String n){
		if(null == n) return new ArrayList<String>();
		if(n.length() == 1){
			List<String> list = new ArrayList<>();
			list.add(n);
			return list;
		}
		
		String head = String.valueOf(n.charAt(0));
		String rem = n.substring(1, n.length());
		
		List<String> res = permute(rem);
		
		List<String> list = new ArrayList<>();
		for (String string : res) {
			for (int i = 0; i <= string.length(); i++) {
				String pre = string.substring(0, i);
				String post = string.substring(i, string.length());
				list.add(pre+head+post);
			}
		}
		return list;
	}
	
}











