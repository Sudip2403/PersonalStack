package com.self.amazon.modules.CountBinaryTreeDP;

public class CountBinaryTreeDP {

	public static void main(String[] args) {
		countTreeDP(7);
	}
	
	
	public static void countTreeDP(int n) {
		long a[][] = new long[n+2][n+1];
		for(int i = 0 ; i < n+2 ; i++){
			a[i][0] = 1L;
		}
			
		long sum = 0;
		for (int i = 1; i < n+1; i++) {
			sum = 0;
			for (int j = 1; j <= i; j++) {
				a[j][i] = a[n+1][i - j] * a[n+1][j - 1];
				sum += a[j][i];
			}
			a[n+1][i] = sum;
		}
			
		for(int i = 1 ; i < n+1 ; i++){
			//System.out.println("Trees possible with " + i + " unique elements " +a[n+1][i]);
		}
		print(a, n+2, n+1);
	}
	
	public static void print(long a[][], int x, int y){
		for(int i = 0; i< x; i++){
			for (int j= 0; j<y; j++){
				System.out.print(a[i][j] + " " );
			}
			System.out.println();
			
		}
	}
}
