package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortEncodingOfWords {

	public static void main(String[] args) {
		String[] words = { "time", "me", "bell" };
		System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(words));
	}

	public int minimumLengthEncoding(String[] words) {
		String complete = "";
		Map<String, Boolean> map = new HashMap<>();
		for (String s : words){
			if(!map.containsKey(s))
				complete += s + "#";
			map.put(s, true);
		}
		int n = complete.length();
		List<int[]> lcps = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			lcps.add(lps(words[i]));
		}
		for (int i = 0; i < words.length; i++) {
			n -= findMatch(complete.toCharArray(), words[i].toCharArray(), lcps.get(i));
		}
		return n;
	}

	int findMatch(char[] text, char[] pat, int[] lcp) {
		int i = 0, j = 0;
		while (i < text.length) {
			if (j == pat.length) {
				if (i - pat.length - 1 >= 0 && text[i] == '#' && text[i - pat.length - 1] != '#') {
					return pat.length + 1;
				}
				j = 0;
			}
			if (i < text.length && j < pat.length && text[i] == pat[j]) {
				i++;
				j++;
			} else if (j > 0) {
				j = lcp[j - 1];
			} else {
				i++;
			}
		}
		return 0;
	}

	int[] lps(String w) {
		char[] c = w.toCharArray();
		int[] lcp = new int[c.length];
		for (int i = 1; i < c.length; i++) {
			int k = 0;
			if (c[i] == c[lcp[i - 1]])
				lcp[i] = lcp[i - 1] + 1;
			else {
				while (k < i) {
					if (c[k] == c[i]) {
						k++;
					} else {
						break;
					}
				}
				lcp[i] = k;
			}
		}
		return lcp;
	}
}
