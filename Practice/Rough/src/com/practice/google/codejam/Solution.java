package com.practice.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      
	      int p = (int)Math.pow(10, (int)(Math.log10(n))), y = p;
	      String A = "", B = "";
	      while(p > 0){
	    	  int k = n/p;
	    	  n = n % p;
	    	  int q = p == y ? 1 : 0;
	    	  while(q < k || p > 0){
	    		  if(q == 4)
	    			  continue;
	    		  if(k - q != 4){
	    			  A += q;
	    			  B += k - q;
	    			  break;
	    		  }
	    		  q++;
	    	  }
	    	  p /= 10;
	      }
	      
	      System.out.println("Case #" + i + ": " + A + " " + B);
	    }
	}	
}
