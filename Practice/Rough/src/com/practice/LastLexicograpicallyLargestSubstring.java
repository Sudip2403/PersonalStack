package com.practice;

public class LastLexicograpicallyLargestSubstring {

	public String lastSubstring(String s) {
		int m = 0, i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) - 'a' > m) {
				m = s.charAt(j) - 'a';
				i = j;
			}
		}
		return s.substring(i, s.length());
	}

	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(new LastLexicograpicallyLargestSubstring().lastSubstring(s));
	}

}
