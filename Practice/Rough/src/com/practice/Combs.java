package com.practice;

public class Combs {

	public static void main(String[] args) {
		String a = "*.**", b = "*.*";
		System.out.println(new Combs().combs(a, b));		
	}
	
	int combs(String a, String b) {
		char[] p = a.toCharArray(), q = b.toCharArray();
		int f = p.length, g = q.length;
		int m = f + g + 4, i = 0, j = 0;
		while (i < f) {
			int u = i;
			j = 0;
			boolean r = true;
			while (j < g) {
				if (u < f && ((p[u] == '*' && q[j] == '.') || (p[u] == '.' && q[j] == '*'))) {
					u++;
					j++;
				} else {
					if (u < f)
						r = false;
					break;
				}
			}
			if (r)
				m = Math.min(m, i + (f - i) + (g - j));
			i++;
		}
		return m;
	}

}
