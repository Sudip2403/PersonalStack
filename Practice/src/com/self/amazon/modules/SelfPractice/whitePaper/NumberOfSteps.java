package com.self.amazon.modules.SelfPractice.whitePaper;



public class NumberOfSteps{

	
	public static void main(String[] args){
		System.out.println(countSteps(new int[][]{{1, 1}}, new int[][]{{0, 3}}));
	}
	
	private static int countSteps(int[][] p1, int[][] p2){
		
		int l, m, n, p;
		
		if(p1[0][0] < p2[0][0]) {
			l = p1[0][0];
			m = p2[0][0];
		}else{
			l = p2[0][0];
			m = p1[0][0];
		}
		
		if(p1[0][1] < p2[0][1]) {
			n = p1[0][1];
			p = p2[0][1];
		}else{
			n = p2[0][1];
			p = p1[0][1];
		}
		
		return ( p - n) + (m - l);		
	}

}