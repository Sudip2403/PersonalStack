package com.practice.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			char[] c = s.toCharArray();
			int[] a = new int[26];
			boolean f = true;
			for (int j = 0; j < c.length; j++) {
				if (a[c[j] - 'a'] > 0)
					f = false;
				a[c[j] - 'a']++;
			}
			if (f) {
				boolean p = false;
				int u = 0;
				for (int j = 0; j < 26; j++) {
					if (p && a[j] == 0 && u < c.length)
						f = false;
					if (a[j] == 1) {
						p = true;
						u++;
					}
				}
			}
			System.out.println(f ? "Yes" : "No");
		}
	}
}
