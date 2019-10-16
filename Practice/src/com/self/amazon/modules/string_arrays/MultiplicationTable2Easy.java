package com.self.amazon.modules.string_arrays;

import java.util.Arrays;
import java.util.PriorityQueue;


public class MultiplicationTable2Easy
{
	
	public static void main(String[] args) {
		System.out.println(new MultiplicationTable2Easy().isGoodSet(new int[]{1,1,2,3,1,0,2,3,3,3,0,3,2,2,2,0}, new int[]{0,1}));
	}
	public String isGoodSet(int[] table, int[] t)
	{
		int n = (int)Math.sqrt(table.length);	
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = table[i*n + j];
			}
		}
		
		boolean flag = true;	
		for(int m = 0; m < t.length; m++){		
			for(int p = 0; p < t.length; p++){		
				int op = arr[t[m]][t[p]];
				if(!Arrays.asList(t).contains(op)){
					flag = false;
					break;
				}
			}
		}
		
		if(flag)
			return "Good";
		else 
			return "Not Good";
	}
	
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!