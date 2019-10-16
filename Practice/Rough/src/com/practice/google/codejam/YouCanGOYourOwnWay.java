package com.practice.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YouCanGOYourOwnWay {

	static int[] x = { 0, 1, 0, -1 };
	static int[] y = { 1, 0, -1, 0 };
	static char[] d = { 'E', 'S', 'W', 'N' };

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			boolean[][] m = new boolean[n][n];
			String s = in.next();
			int xp = 0, yp = 0;
			Map<String, String> map = new HashMap<>();
			for (int j = 0; j < s.length(); j++) {
				String k = xp + "-" + yp;
				if (s.charAt(j) == 'E')
					yp += 1;
				if (s.charAt(j) == 'S')
					xp += 1;
				if (s.charAt(j) == 'W')
					yp -= 1;
				if (s.charAt(j) == 'N')
					xp -= 1;
				map.put(k, xp + "-" + yp);
			}
			String[] q = { "" };
			dfs(m, 0, 0, "", n, false, q, map);
			System.out.println("Case #" + i + ": " + q[0]);
		}
	}

	static boolean dfs(boolean[][] m, int xp, int yp, String r, int n, boolean f, String[] q, Map<String, String> map) {
		if (xp == n - 1 && yp == n - 1) {
			q[0] = r;
			return true;
		}
		for (int i = 0; i < 4; i++) {
			int nx = xp + x[i], ny = yp + y[i];
			String ch = map.get(xp + "-" + yp);
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !m[nx][ny]
					&& (ch == null || (ch != null && !ch.equals(nx + "-" + ny)))) {
				m[nx][ny] = true;
				if (!f)
					f = dfs(m, nx, ny, r + d[i], n, f, q, map);
				m[nx][ny] = true;
			}
		}
		return f;
	}

}
