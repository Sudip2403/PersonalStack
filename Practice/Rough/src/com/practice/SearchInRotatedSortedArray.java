package com.practice;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 1 };
		int target = 1;
		System.out.println(new SearchInRotatedSortedArray().search(nums, target));
	}

	public boolean search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (low == high)
				return target == nums[low];
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[low] <= nums[mid] && target >= nums[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}
}
