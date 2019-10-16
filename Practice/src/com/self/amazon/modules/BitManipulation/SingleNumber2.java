package com.self.amazon.modules.BitManipulation;

public class SingleNumber2 {

	public static void main(String[] args) {
		//int n = singleNumber(new int[] {5, 1, 3, 2, 1, 5, 3, 2, 1, 4, 5, 2, 3});
		int n = tempSingleNumber(new int[] {1, 1, 1, 2, 2, 2, 3});
		System.out.println(n);
	}
	
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	    	//System.out.println("2s" + (twos | ones & A[i]));
	        twos |= ones & A[i];
	        //System.out.println("1s" + (ones ^ A[i]));
	        ones ^= A[i];
	        //System.out.println("3s" + ( ones & twos));
	        threes = ones & twos;
	        //System.out.println("1s final" + ( ones & ~threes));
		    ones &= ~threes;
		    //System.out.println("2s final" + ( twos & ~threes));
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	public static int tempSingleNumber(int[] A) {
		int x = 0;
		for (int i = 0; i < A.length; i++) {
			x = (x ^ A[i]);
		}
		return x;
	}
}
