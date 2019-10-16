package com.self.amazon.modules.SelfPractice;

public class ArraySpiralMatrix {

	public static void main(String[] args) {
		int[][] arr = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
		
		int[] a = spiral(arr, 3, 3);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		int n = 4;
		int[][] sp = spiral2(n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sp[i][j] + ",");
			}
			System.out.println();
		}
		
	}
	
	private static int[] spiral(int[][] a, int m, int n){
		int[] arr = new int[m * n];
		int c = 0;
		boolean f = true;
		for (int i = 0; i < m; i++) {
			if(f){
				for (int j = 0; j < n; j++) {
					arr[c++] = a[i][j];
				}
			}else{
				for (int j = n-1; j >= 0; j--) {
					arr[c++] = a[i][j];
				}
			}
			f = !f;
		}
		return arr;
	}
	
	private static int[][] spiral2(int n){
		int[][] arr = new int[n][n];
		int co = 1;
		int r = 0; int c= 0;
		boolean f = true;
		boolean ld = true;
		
		int i = 0;
		while(i < n){
			if(co == n*n)
				break;
			
			if(ld){
				if(f)
					c = i++;
				else
					r = i++;
			}else{
				if(f)
					c = i--;
				else
					r = i--;
			}
			
			
			if(arr[r][c] == 0)
				arr[r][c] = co++;
			
			if(ld && i == n){
				int t = c;
				c = r;
				r = t;
				f = !f;
				i = 0;
			}else if(!ld && i == 0){
				int t = c;
				c = r;
				r = t;
				f = !f;
				i = 0;
			}
		} 
		return arr;
	}
}
