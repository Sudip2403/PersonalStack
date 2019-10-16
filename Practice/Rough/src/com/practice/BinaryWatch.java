package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch {

	public static void main(String[] args) {
		int num = 2;
		System.out.println(new BinaryWatch().readBinaryWatch(num));
	}

	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>(time(new HashSet<>(), new int[4], new int[6], 3, 5, num));
		Collections.sort(result);
		return result;
	}

	Set<String> time(Set<String> times, int[] hour, int[] mins, int h, int m, int nums) {
		if (nums == 0) {
			String t = calculateTime(hour, mins);
			if (!t.equals("0:00"))
				times.add(t);
			return times;
		}
		for (int i = h; i >= 0; i--) {
			if (nums > 0) {
				hour[i] = 1;
				times = time(times, hour, mins, i - 1, m, nums - 1);
				hour[i] = 0;
			}
		}
		for (int i = m; i >= 0; i--) {
			if (nums > 0) {
				mins[i] = 1;
				times = time(times, hour, mins, h, i - 1, nums - 1);
				mins[i] = 0;
			}
		}
		return times;
	}

	String calculateTime(int[] hr, int[] m) {
		StringBuffer hour = new StringBuffer(), mins = new StringBuffer();
		for (int i = 0; i < 4; i++)
			hour.append(hr[i]);
		for (int i = 0; i < 6; i++)
			mins.append(m[i]);

		String h = String.valueOf((Integer.parseInt(hour.toString(), 2) % 12));
		String min = String.valueOf(Integer.parseInt(mins.toString(), 2));
		if (min.length() == 1)
			min = "0" + min;
		return h + ":" + min;
	}
}
