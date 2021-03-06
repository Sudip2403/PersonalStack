package com.self.amazon.modules.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		List<Integer> g = grayCode(2);
		System.out.println(g);
	}
	
	public static List<Integer> grayCode(int n) {
	    if(n==0){
	        List<Integer> result = new ArrayList<Integer>();
	        result.add(0);
	        return result;
	    }
	 
	    List<Integer> result = grayCode(n-1);
	    int numToAdd = 1<<(n-1);
	 
	    for(int i=result.size()-1; i>=0; i--){
	        result.add(numToAdd+result.get(i));
	    }
	 
	    return result;
	}
}
