package com.self.amazon.modules.SelfPractice;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestSubsequence("ABCBDAB", "BDCABA"));
	}
	
	private static int longestSubsequence(String a, String b){
		int[][] arr = new int[a.length() + 1][b.length() + 1];
		
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
	
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				
				else if(a.charAt(i-1) == b.charAt(j-1))
					arr[i][j] = arr[i-1][j-1] + 1;
				
				else
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				
			}	
		}
		
		return arr[a.length()][b.length()];
	}
	
	
	
	public static int getLongestCommonSubsequence(String a, String b){
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
	 
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}else if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	 
		return dp[m][n];
	}
}
