package com.practice;

import java.util.ArrayList;
import java.util.List;

public class MedRegimen {

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 8, 72, 32 };
		Integer[][] r = new MedRegimen().medRegimen(a);
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[i].length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}

	Integer[][] medRegimen(int[] a) {
		int t = 0, j = 0;
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> k = new ArrayList<>();
		r.add(k);
		for (int i : a) {
			int p = t + i;
			while (p >= 24) {
				p -= 24;
				k = new ArrayList<>();
				r.add(k);
			}
			k.add(p);
			t = p;
		}
		Integer[][] q = new Integer[r.size()][];
		for (List<Integer> l : r)
			q[j++] = l.toArray(new Integer[l.size()]);
		return q;
	}

}
