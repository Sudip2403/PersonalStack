package com.self.amazon.modules.DynamicPrograming;

public class MinPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{ new int[]{11, 13, 7, 8}, new int[]{6, 1, 16, 4}, new int[]{14, 12, 2, 10}, new int[]{3, 9, 15, 5}}));
	}
	
	public static int minPathSum(int[][] grid) {
	    if(grid == null || grid.length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[][] dp = new int[m][n];
	    dp[0][0] = grid[0][0];    
	 
	    // initialize top row
	    for(int i=1; i<n; i++){
	        dp[0][i] = dp[0][i-1] + grid[0][i];
	    }
	 
	    // initialize left column
	    for(int j=1; j<m; j++){
	        dp[j][0] = dp[j-1][0] + grid[j][0];
	    }
	 
	    // fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            if(dp[i-1][j] > dp[i][j-1]){
	                dp[i][j] = dp[i][j-1] + grid[i][j];
	            }else{
	                dp[i][j] = dp[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return dp[m-1][n-1];
	}
}
