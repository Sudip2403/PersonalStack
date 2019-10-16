package com.practice;

public class IsTandemRepeatEx {

	public static void main(String[] args) {
		String s = "TCGGGTCCGACGGCCCATTC";
		System.out.println(new IsTandemRepeatEx().isTandemRepeatEx(s));
	}
	
	int isTandemRepeatEx(String s) {
		char[] c = s.toCharArray();
		int n = c.length, i = 0, m = 0;
		while (i < n - 1) {
			int j = i + 1;
			while (j < n && c[i] != c[j])
				j++;
			if (j < n) {
				int p = i, q = j;
				int v = 0;
				while (p < j && q < n && c[p] == c[q]) {
					p++;
					q++;
					v++;
				}
				m = Math.max(m, v);
			}
			i++;
		}
		return m;
	}

}
