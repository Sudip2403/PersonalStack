package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {
		String s = "abpcplea";
		String[] d = { "ale", "apple", "monkey", "plea" };
		System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord(s, Arrays.asList(d)));
	}

	public String findLongestWord(String s, List<String> d) {
		List<Integer>[] indices = new ArrayList[26];
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			List<Integer> index = indices[c - 'a'];
			if (index == null)
				index = new ArrayList<>();
			index.add(i);
			indices[c - 'a'] = index;
		}
		Collections.sort(d, new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.length() > b.length())
					return -1;
				if (a.length() < b.length())
					return 1;
				return a.compareTo(b);
			}
		});

		for (String w : d) {
			char[] f = w.toCharArray();
			int lastIndex = -1;
			boolean found = true;
			for (int i = 0; i < f.length; i++) {
				List<Integer> index = indices[f[i] - 'a'];
				if (index == null) {
					found &= false;
					break;
				}
				boolean bh = false;
				for (int h : index) {
					if (h > lastIndex) {
						lastIndex = h;
						bh = true;
						break;
					}
				}
				found &= bh;
			}
			if (found)
				return w;
		}
		return "";
	}
}
