package com.self.amazon.modules.string_arrays;

public class IncreasingTriplet {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[]{1, 5, 3, 2, 8}));
	}
	
	public static boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
	 
		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
	 
			if (x >= z) {
				x = z;// update x to be a smaller value
			} else if (y >= z) {
				y = z; // update y to be a smaller value
			} else {
				return true;
			}
		}
	 
		return false;
	}
}
