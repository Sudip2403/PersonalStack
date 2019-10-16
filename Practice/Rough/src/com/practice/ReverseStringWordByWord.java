package com.practice;

public class ReverseStringWordByWord {

	public String reverseWords(String s) {
		StringBuffer r = new StringBuffer();
		String sb = new String();
		int n = s.length() - 1;
		while(n >= 0){
			if(s.charAt(n) == ' '){
				if(!sb.isEmpty())
					r.append(" " + sb);
				sb = "";
			}else {
				sb = s.charAt(n) + sb;
			}
			n--;
		}
		r.append(" " + sb);
		return r.toString().trim();
	}
	
	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(new ReverseStringWordByWord().reverseWords(s));
	}

}
