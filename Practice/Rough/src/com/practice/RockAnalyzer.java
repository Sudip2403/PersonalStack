package com.practice;

public class RockAnalyzer {

	public static void main(String[] args) {
		String[][] a = { { "Led Zeppelin", "Led Zeppelin IV" }, { "Black Dog", "4:54" }, { "Rock and Roll", "3:40" },
				{ "The Battle of Evermore", "5:51" }, { "Stairway to Heaven", "8:02" },
				{ "Misty Mountain Hop", "4:38" }, { "Four Sticks", "4:44" }, { "Going to California", "3:31" },
				{ "When the Levee Breaks", "7:07" } };
		String[][] r = new RockAnalyzer().RockAnalyzer(a);
		for (String[] s : r) {
			for (String t : s) {
				System.out.print(t + ", ");
			}
			System.out.println();
		}
	}

	String[][] RockAnalyzer(String[][] a) {
		int n = a.length;
		int sc = -1, sct = Integer.MAX_VALUE, lc = -1, lct = -1, st = -1, stl = Integer.MAX_VALUE, lt = -1, ltl = -1;
		for (int i = 1; i < n; i++) {
			int t = f(a[i][1]), l = a[i][0].length();
			if (t < sct) {
				sct = t;
				sc = i;
			}
			if (t > lct) {
				lct = t;
				lc = i;
			}
			if (l < stl) {
				stl = l;
				st = i;
			}
			if (l > ltl) {
				ltl = l;
				lt = i;
			}
		}
		String[][] r = new String[][] { { a[0][0], a[0][1] }, { "The shortest composition", a[sc][0], a[sc][1] },
				{ "The longest composition", a[lc][0], a[lc][1] }, { "The shortest title", a[st][0], stl + "" },
				{ "The longest title", a[lt][0], ltl + "" } };
		return r;
	}

	int f(String t) {
		return Integer.parseInt(t.substring(0, t.indexOf(":"))) * 60
				+ Integer.parseInt(t.substring(t.indexOf(":") + 1, t.length()));
	}
}
