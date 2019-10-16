package com.practice;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int r = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
		System.out.println(r);
	}

	public int removeDuplicates(int[] nums) {
		int n = nums.length, count = n, i = 0;
		while (i < count) {
			int j = i;
			while (j < count && nums[j] == nums[i])
				j++;
			if (j - i > 2) {
				shift(nums, i + 2, j, count);
				count -= (j - i - 2);
				i++;
			}
			i++;
		}
		return count;
	}

	void shift(int[] nums, int i, int j, int n) {
		for (int k = j; k < n; k++) {
			nums[i++] = nums[k];
		}
	}
}
