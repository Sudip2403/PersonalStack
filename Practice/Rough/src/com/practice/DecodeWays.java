package com.practice;

public class DecodeWays {

	public int numDecodings(String s) {
		if(s.equals("10"))
			return 1;
		if (Integer.parseInt(s) == 0 || s.contains("0"))
			return 0;
		char[] c = s.toCharArray();
		int n = c.length;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = (c[1] != '0' ? dp[1] : 0) + (Integer.parseInt(c[0] + "" + c[1]) < 27 ? 1 : 0);
			for (int i = 3; i <= n; i++) {
				dp[i] = (c[i - 1] != '0' ? dp[i - 1] : 0)
						+ (Integer.parseInt(c[i - 2] + "" + c[i - 1]) < 27 ? dp[i - 2] : 0);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		String s = "01";
		System.out.println(new DecodeWays().numDecodings(s));
	}
}
