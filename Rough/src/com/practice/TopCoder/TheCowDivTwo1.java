package com.practice.TopCoder;

public class TheCowDivTwo1 {

	public static void main(String[] args) {
		int N = 4;
		int K = 2;
		
		int ans = new TheCowDivTwo1().find(N, K);
		System.out.println(ans);
		
		int table[][][][] = new int[2][K+1][N][2];
		
		System.out.println();
	}
	
	int find(int N, int K)
	{
	    //Note that memory is now only O(K*N).
	    int table[][][] = new int[2][K+1][N];
	    for (int p = N; p>=0; p--) {
	      for (int k = 0; k<=K; k++) {
	        for (int s = 0; s<N; s++) {
	          if (k == 0) {
	            if (s==0) {
	                table[p%2][k][s] = 1;
	            } else {
	                table[p%2][k][s] = 0;
	            }
	          } else if (p == N) {
	            table[p%2][k][s] = 0;
	          } else {
	            table[p%2][k][s] = table[(p+1)%2][k-1][ ( s-p+N )%N ] //Use p
	                             + table[(p+1)%2][k][s];        //Don't use p
	                             
	            //We only need the result Modulo 1000000007
	            table[p%2][k][s] %= 1000000007;
	          }
	        }
	      }
	    }
	    
	    // The result is to call the recurrence when
	    //   p = 0, k = K, and S=0
	    return table[0 % 2][K][ 0 ];

	}
}
