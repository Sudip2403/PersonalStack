package com.self.amazon.modules.SelfPractice;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[]{6, 10, 13, 5, 8, 3, 2, 11};
		int[] s = shellSort(arr);
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	private  static int[] shellSort(int[] arr){
		int gap = 2;
		
		while(arr.length/gap >= 2){
			int l = arr.length % gap == 0 ? arr.length/gap : arr.length/gap +1;
			
			int[][] br = new int[gap][l];	
			int r = -1;
			int c = 0;
			int maxCol = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if(i % l == 0){
					r += 1;
					c = 0;
				}
				br[r][c++] = arr[i];
				maxCol = Math.max(maxCol, c);
			}
		
			arr = sort(br, r, maxCol);
			gap += 1;
		}
		
		int[] s = new int[arr.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = arr[i];
		}
		
		insertionSort(s);
		
		return s;
	}
	
	
	private static int[] sort(int[][] arr, int r, int c){
		
		int[] ret = new int[(r + 1) * c];
		int d = 0;
		
		for (int i = 0; i < c; i++) {
			int[] a = new int[r + 1];
			for (int j = 0; j <= r; j++) {
				a[j] = arr[j][i];
			}
			insertionSort(a);
			
			int k = a.length + d;
			int o = 0;
			for (int j = d; j < k; j++) {
				ret[j] = a[o];
				d++; o++;
			}
			
			
		}
		return ret;
	}
	
	private static void insertionSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j-1] > arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
}
