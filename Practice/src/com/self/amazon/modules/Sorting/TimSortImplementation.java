package com.self.amazon.modules.Sorting;

import java.util.*;

public class TimSortImplementation {


	public static void main(String[] args) {
		
		Integer a[] = new Integer[]{1, 5, 4, 77, 50, 90, 100, 21, 88, 0, 3, 4, 77, 65, 25, 2, 24, 88, 64, 221, 141, 22, 7, 9, 10, 44, 81, 79, 50, 101, 145, 174, 135, 214, 634, 98, 40, 20, 11, 121};
		
		TimSort.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n--------------------------------------------------------");
	}
}
