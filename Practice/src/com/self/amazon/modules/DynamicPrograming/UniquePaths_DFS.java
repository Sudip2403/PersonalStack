package com.self.amazon.modules.DynamicPrograming;

public class UniquePaths_DFS {

	public static void main(String[] args) {
		UniquePaths_DFS paths_DFS = new UniquePaths_DFS();
		System.out.println(paths_DFS.uniquePaths(2, 2));
	}
	
	public int uniquePaths(int m, int n) {
	    return dfs(0,0,m,n);
	}
	 
	public int dfs(int i, int j, int m, int n){
	    if(i==m-1 && j==n-1){
	        return 1;
	    }
	 
	    if(i<m-1 && j<n-1){
	        return dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
	    }
	 
	    if(i<m-1){
	        return dfs(i+1,j,m,n);
	    }
	 
	    if(j<n-1){
	        return dfs(i,j+1,m,n);
	    }
	 
	    return 0;
	}
}
