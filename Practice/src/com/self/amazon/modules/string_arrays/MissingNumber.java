package com.self.amazon.modules.string_arrays;

public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0, 1, 3, 4}));
	}
	
	public static int missingNumber(int[] nums) {
		 
	    int miss=0;
	    for(int i=0; i<nums.length; i++){
	        miss ^= (i+1) ^nums[i];
	    }
	 
	    return miss;
	}
}
