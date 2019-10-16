package com.practice;

import java.util.Map;
import java.util.TreeMap;

public class DecodedStringAtIndex {

	public static void main(String[] args) {
		String S = "a2b3cx";
		int K = 8;
		System.out.println(new DecodedStringAtIndex().decodeAtIndex(S, K));
	}

	public String decodeAtIndex(String S, int K) {
		char[] c = S.toCharArray();
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		int l = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 48 && c[i] <= 57) {
				int k = Integer.parseInt(c[i] + "");
				l *= k;
				m.put(l, i);
			} else
				l++;
		}
		m.put(l, c.length);
		return g(m, K, S) + "";
	}

	private char g(Map<Integer, Integer> m, int K, String S) {
		int lindex = 0;
		for (Map.Entry<Integer, Integer> d : m.entrySet()) {
			if (d.getKey() >= K) {
				int g = K % (lindex + d.getValue() - m.get(lindex) - 1);
				if (lindex == 0)
					return S.charAt(m.get(lindex));
				return g(m, g, S.substring(0, d.getValue()));
			}
			lindex = d.getKey();
		}
		return ' ';
	}
}
