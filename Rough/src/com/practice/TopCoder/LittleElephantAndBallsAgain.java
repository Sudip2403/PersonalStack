package com.practice.TopCoder;

import java.util.Arrays;


public class LittleElephantAndBallsAgain {
	
	
	public static void main(String[] args) {
		System.out.println(getNumber1("RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"));
	}

	
	
	public static int getNumber1(String s){
		int[] a = new int[s.length()];
		Arrays.fill(a, Integer.MAX_VALUE);
		
		int matchIndex = 0;
		int c = 0;
		for(int i = 0; i< s.length() - 1; i++){
			if(s.charAt(i) != s.charAt(i + 1)){
				a[c++] = (matchIndex) + (s.length() - i - 1);
				matchIndex = i + 1;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int j = 0; j<a.length; j++){
			if(a[j] < min){
				min = a[j];
			}
		}
		if(min == Integer.MAX_VALUE){
			min = 0;
		}
		
		return min;
	}
	
	
	public static int getNumber(String s){
		int num = 0;		
		for(int i=0, j=s.length()-1; i<s.length() && j>i; i++, j--){
			if(s.charAt(i) != s.charAt(i+1)){
				num = i + 1; 
			}
			if(s.charAt(j) != s.charAt(j-1) && j-i > 1){
				num = num + (s.length() - j);
			}else if(s.charAt(j) != s.charAt(j-1)){
				num = num + (s.length() - j -1);
			}
		}
		return num;
	}
	
	
	

}
