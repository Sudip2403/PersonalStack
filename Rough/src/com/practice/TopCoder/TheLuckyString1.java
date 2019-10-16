package com.practice.TopCoder;

public class TheLuckyString1 {

	public static void main(String[] args) {
		stringPermutation("abc");
	}
	
	private static void stringPermutation(String s){
		int[] alphabets = new int[26];
		
		for(int i = 0; i< s.length(); i++){
			alphabets[s.charAt(i) - 'a']++;
		}
		System.out.println();
	}
	
	private void permute(int[] alphabets){
		
		for(int i = 'a'; i<='z' ; i++){
			
		}
	}
	
}
