package com.practice;

public class MinDeIN {

	public static void main(String[] args) {
		String m = "16039993504999042559";
		int n = 11;
		System.out.println(new MinDeIN().minDelN(m, n));
	}

	String minDelN(String m, int n) {	
		char[] c = m.toCharArray();
		int[] a = new int[10];
		for (int i = 0; i < c.length; i++)
			a[c[i] - '0']++;
		int k = 9;
		while (n > 0) {
			while (a[k] < 1)
				k--;
			int i = m.indexOf(k + "");
			String u = m.substring(0, i) + m.substring(i + 1, m.length());
			if(u.compareTo(m.substring(1, m.length())) < 0){
				m = u;
				a[k]--;
			}else{
				a[m.charAt(0) - '0']--;
				m = m.substring(1, m.length());
			}
			n--;
		}
		return String.valueOf(Integer.parseInt(m));
	}

}
