package com.self.amazon.modules.SelfPractice;

public class LongestPalindromeSubSequence {

	
	public static void main(String[] args) {
		System.out.println(maxPalindromeSeq("ACECC"));
	}
	
	private static int maxPalindromeSeq(String a){
		if(a == null) return 0;
		if(a.length() == 1) return 1;
		
		int[][] arr = new int[a.length()][a.length()];
		
		for (int i = 0; i < a.length(); i++) {
			arr[i][i] = 1;
		}
		
		for (int j = 0; j < a.length(); j++) {
			for (int i = j-1; i >=0; i--) {
				
				if(a.charAt(i) != a.charAt(j))
					arr[i][j] = Math.max(arr[i][j-1], arr[i+1][j]);
				else
					arr[i][j] = 2 + arr[i+1][j-1];
			}
		}
		
		return arr[0][a.length() - 1];
	}
}
