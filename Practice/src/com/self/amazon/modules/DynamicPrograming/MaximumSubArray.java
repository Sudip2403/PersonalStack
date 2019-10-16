package com.self.amazon.modules.DynamicPrograming;

public class MaximumSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
	}
}
