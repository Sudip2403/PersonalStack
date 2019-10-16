package com.self.amazon.modules.BitManipulation;

public class MaxumimBinaryGap {

	public static void main(String[] args) {
		int n = getGap(9);
		System.out.println(n);
	}
	
	public static int getGap(int N) {
		int max = 0;
		int count = -1;
		int r = 0;
	 
		while (N > 0) {
			// get right most bit & shift right
			r = N & 1;
			N = N >> 1;
	 
			if (0 == r && count >= 0) {
				count++;
			}
	 
			if (1 == r) {
				max = count > max ? count : max;
				count = 0;
			}
		}
	 
		return max;
	}
	
	
	public static int getGap1(int N) {
		int pre = -1;
		int len = 0;
	 
		while (N > 0) {
			int k = N & -N;
			
			System.out.println(Integer.toBinaryString(N));
			System.out.println(Integer.toBinaryString(-N));// 2's complement
	 
			int curr = (int) Math.log(k);
	 
			N = N & (N - 1);
	 
			if (pre != -1 && Math.abs(curr - pre) > len) {
				len = Math.abs(curr - pre) + 1;
			}
			pre = curr;
		}
	 
		return len;
	}
}
