package com.practice;

public class RecurssionUsed {

	public static void main(String[] args) {
		String s = "string removeZ(int x) => x > 2? \"7\" : \"removeZ(x--)\";";
		System.out.println(new RecurssionUsed().recUsed(s));
	}

	String recUsed(String s) {
		char[] c = s.toCharArray();
		int i = 0, n = c.length;
		while (i < n) {
			String p = "", m = "";
			while (i + 1 < n && c[i + 1] != '(')
				i++;
			int k = i, o = i, l = 0;
			while (i < n && c[i] != ')')
				p += c[i++];
			while (k >= 0 && c[k] != ' ')
				m = c[k--] + m;
			l = p.split(",").length;
			int u = s.lastIndexOf(m);
			if (u > o) {
				int y = u;
				u += m.length() + 1;
				String t = "";
				while (u < n && c[u] != ')')
					t += c[u++];
				if (t.split(",").length == l && c[y - 1] != '"')
					return "used";
			}
			i++;
		}
		return "not used";
	}

}
