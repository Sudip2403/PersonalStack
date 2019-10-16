package com.practice;

public class ArrayPermutations {

	public static void main(String[] args) {
	    int a[]={3,4,5};
	    int b[]={3,5,4};
	 
	    int aZeroes = 0;
	    int bZeroes = 0;
	    int aOnes = 0;
	    int bOnes = 0;
	    int sumA = 0;
	    int productA = 1;
	    int sumB = 0;
	    int productB = 1;
	 
	    for (int i = 0; i < a.length; i++) {
	        if (a[i] == 0) {
	            aZeroes++;
	        } else if (a[i] == 1) {
	            sumA += a[i];
	            aOnes++;
	        } else {
	            sumA += a[i];
	            productA *= a[i];
	        }
	    }
	 
	    for (int i = 0; i < b.length; i++) {
	        if (b[i] == 0) {
	            bZeroes++;
	        } else if (b[i] == 1) {
	            sumB += b[i];
	            bOnes++;
	        } else {
	            sumB += b[i];
	            productB *= b[i];
	        }
	    }
			
	    if(aZeroes == bZeroes && aOnes == bOnes && sumA == sumB && productA == productB)
	        System.out.println("PREMUTATION");
	    else
	        System.out.println("NOT PERMUTATION");
	}
}
