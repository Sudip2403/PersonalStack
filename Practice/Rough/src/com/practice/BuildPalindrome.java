package com.practice;

public class BuildPalindrome {

	public static void main(String[] args) {
		String s = "abcdc";
		System.out.println(new BuildPalindrome().buildPalindrome1(s));
	}

	String buildPalindrome1(String s) {
		char[] c = s.toCharArray();
		int n = c.length - 1, m = 0, i = 0, q = 0;
		while (i < n) {
			int k = 0;
			while (i - k >= 0 && i + k < n && c[i - k] == c[i - k]) {
				k++;
				if (k >= m) {
					m = k;
					q = i;
				}
			}
			i++;
		}
		i = n - q - 1;
		while (q - i >= 0) {
			s += c[q - i];
			i++;
		}
		return s;
	}

	String buildPalindrome(String s) {
		int h = s.length() - 1, l = 0;
		while (l <= h) {
			if (s.charAt(l) != s.charAt(h)) {
				s = s.substring(0, h + 1) + s.charAt(l) + s.substring(h + 1, s.length());
				l++;
			} else {
				l++;
				h--;
			}
		}
		return s;
	}

}
