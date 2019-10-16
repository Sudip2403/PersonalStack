package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumK {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int k = 2;
		System.out.println(new SubArraySumK().subarraySum(nums, k));
	}

	public int subarraySum(int[] nums, int k) {
		int n = nums.length, sum = nums[0];

		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> v = new ArrayList<>();
		v.add(0);
		map.put(nums[0], v);

		for (int i = 1; i < n; i++) {
			sum += nums[i];
			List<Integer> list = map.get(sum);
			if (list == null)
				list = new ArrayList<>();
			list.add(i);
			map.put(sum, list);
		}

		int count = 0, s = 0;
		if (map.containsKey(k))
			count += map.get(k).size();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(s + nums[i] - k)) {
				for (int index : map.get(s + nums[i] - k)) {
					if (index < i)
						count++;
				}
			}
			s += nums[i];
		}
		return count;
	}
}
