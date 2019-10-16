package com.practice;

//A table composed of N x M cells, each having a certain quantity of apples, is given. 
//You start from the upper-left corner. At each step you can go down or right one cell. Find the maximum number of apples you can collect.
public class DP_NxM_Matrix {
	
	private static int[][] matrixArr = new int[3][4];
	
	public static void main(String[] args) {
		matrixArr[0][0] = 2;
		matrixArr[0][1] = 5;
		matrixArr[0][2] = 8;
		matrixArr[0][3] = 3;
		
		matrixArr[1][0] = 1;
		matrixArr[1][1] = 0;
		matrixArr[1][2] = 7;
		matrixArr[1][3] = 4;
		
		matrixArr[2][0] = 4;
		matrixArr[2][1] = 6;
		matrixArr[2][2] = 7;
		matrixArr[2][3] = 9;
		
		int apples = traversePath(3, 4);
		System.out.println(apples);
	}
	
	private static int traversePath(int rowMax, int columnMax){
		
		int row = 0;
		int column = 0;
		int count = matrixArr[0][0];
		
		while(!(row >= rowMax && column >= rowMax)){
			int right = row < rowMax && column + 1 < columnMax ? matrixArr[row][column + 1] : 0;
			int down = row + 1 < rowMax && column < columnMax ?matrixArr[row + 1][column] : 0;
			if(right > down){
				count = count + right;
				column++;
			}else{
				count = count + down;
				row++;
			}
		}
		
		return count;
	}
}
