package com.self.amazon.modules.SelfPractice;

public class BinarySearchInMatrix {

	public static void main(String[] args) {
		int[][] arr = new int[][]{new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,50}};
		
		searchMatrix(arr, 3);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) 
                return true;
 
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 
        return false;
    }
}
