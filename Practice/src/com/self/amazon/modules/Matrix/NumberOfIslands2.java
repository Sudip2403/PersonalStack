package com.self.amazon.modules.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {

	public static void main(String[] args) {
		List<Integer> list = numIslands2(4, 4, new int[][]{new int[]{1,1}, new int[]{2,3}, new int[]{3,0}, new int[]{0,2}, {2, 1}});
		System.out.println(list);
	}
	
	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
	    int[] rootArray = new int[m*n];
	    Arrays.fill(rootArray,-1);
	 
	    ArrayList<Integer> result = new ArrayList<Integer>();
	 
	    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	    int count=0;
	 
	    for(int k=0; k<positions.length; k++){
	        count++;
	 
	        int[] p = positions[k];
	        int index = p[0]*n+p[1];
	        rootArray[index]=index;//set root to be itself for each node
	 
	        for(int r=0;r<4;r++){
	            int i=p[0]+directions[r][0];
	            int j=p[1]+directions[r][1];
	 
	            if(i>=0&&j>=0&&i<m&&j<n&&rootArray[i*n+j]!=-1){
	                //get neighbor's root
	                int thisRoot = getRoot(rootArray, i*n+j);
	                if(thisRoot!=index){
	                    rootArray[thisRoot]=index;//set previous root's root
	                    count--;
	                }
	            }
	        }
	 
	        result.add(count);
	    }
	 
	    return result;
	}
	 
	public static int getRoot(int[] arr, int i){
	    while(i!=arr[i]){
	        i=arr[arr[i]];
	    }
	    return i;
	}
}
