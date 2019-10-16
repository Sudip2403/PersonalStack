package com.practice;

public class ReverseStringByK {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		System.out.println(new ReverseStringByK().reverseStrByK(s, k));
	}
	
	String reverseStrByK(String s, int k) {
		char[] c = s.toCharArray();
		int n = c.length, t = k, i = 0;
		boolean y = false;
		String r = "", h = "";
		while (i < n) {
			if (t == 0) {
				t = k;
				if(!y){
					r += h;
					h = "";
				}
				y = !y;
			}
			if (!y) {
				h = c[i] + h;
			} else {
				r += c[i];
			}
			i++;
			t--;
		}
		return r;
	}

}
