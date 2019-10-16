package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 	Let's call a given number cool if its digits can be divided into two sets such that the sum of the digits in one set is equal to the sum of the digits in the other set. 
 * For example, the number 242 is cool because we can divide it into sets {2, 2} and {4}, and the sum of the digits in each set is 4. Given two ints A and B, return how many numbers between A and B, inclusive, are cool.
 
Definition
    	
Class:	CoolNumber
Method:	count
Parameters:	int, int
Returns:	int
Method signature:	int count(int A, int B)
(be sure your method is public)
    
 
Constraints
-	A will be between 1 and 109, inclusive.
-	B will be between A and 109, inclusive.
-	The difference between B and A will be at most 106.
 
Examples
0)	
    	
1
50
Returns: 4
Here we've got following cool numbers: 11, 22, 33, 44.
1)	
    	
1
1000
Returns: 135
2)	
    	
6354
234363
Returns: 82340

 */
public class CoolNumber {
	
	public static void main(String[] args) {
		//System.out.println(count(1, 1000));
		System.out.println(balanced(new Integer[]{5,4,3,2}, false, -1, -1));
	}
	
	static int count(int A, int B){
		Set<Integer> cool = new HashSet<Integer>();
		Set<Integer> notCool = new HashSet<Integer>();
		
		for (int i = A; i <= B; i++) {
			if(!cool.contains(i) && !notCool.contains(i)){
				if(i < 10){
					notCool.add(i);
				}else{
					Integer[] arr = new Integer[String.valueOf(i).length()];
					for (int j = 0; j < arr.length; j++) {
						String str = String.valueOf(i);
						arr[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
					}
					boolean c = balanced(arr, false, -1, -1);
					
					List<String> p = permute(arr);
					if(c){
						for (String s : p) {
							cool.add(Integer.parseInt(s));
						}
					}else if(!c){
						for (String s : p) {
							notCool.add(Integer.parseInt(s));
						}
					}
				}
			}
		}
		return cool.size();
	}
	
	static boolean balanced(Integer[] arr, boolean bal, int p, int q){
		if(null == arr) return false;
		if(arr.length == 1) return false;
		
		if(!bal){
	
			int suml = arr[0];
			int sumr = arr[arr.length-1];
			
			int i = 0;
			int j = arr.length-1;
			
			while(j > i){
				if(suml == sumr && j-i == 1)
					bal = true;
				if(suml < sumr){
					suml += arr[i+1];
					if(j-i > 1)
						i++;
				}
				if(suml > sumr){
					sumr += arr[j-1];
					if(j-i > 1)
						j--;
				}
				else if(suml == sumr && j-i != 1){
					suml += arr[i+1];
					if(j-i > 1)
						i++;
				}
			}
			
			if(!bal){
				if(p == -1 && q == -1){
					p = i;
					q = j;		
				}
					
				Integer[] arrn = swap(arr, p, q);
				if(p > 0)
					bal = balanced(arrn, bal, p-1, q);
				else if(q > 0)
					bal = balanced(arrn, bal, p, q-1);
			}
		}
		return bal;
	}
	
	static Integer[] swap(Integer[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		return arr;
	}

	static List<String> permute(Integer[] arr){
		if(null == arr) return new ArrayList<>();
		if(arr.length == 1){
			List<String> list = new ArrayList<>();
			String str = "";
			for (int i = 0; i < arr.length; i++) {
				str += String.valueOf(arr[i]);
			}
			list.add(str);
			return list;
		}
		
		String head = String.valueOf(arr[0]);
		Integer[] rem = Arrays.asList(arr).subList(1, arr.length).toArray(new Integer[arr.length-1]);
		
		List<String> res = permute(rem);

		List<String> listr = new ArrayList<String>();
		for (String str : res) {
			for (int i = 0; i <= str.length(); i++) {
				String pre = str.substring(0, i);
				String post = str.substring(i, str.length());
				listr.add(pre+head+post);
			}
		}
		return listr;
	}
	
}










