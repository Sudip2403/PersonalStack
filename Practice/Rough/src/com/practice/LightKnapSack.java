package com.practice;

public class LightKnapSack {

	public static void main(String[] args) {
		System.out.println(new LightKnapSack().knapsackLight(15, 2, 20, 3, 2));
	}

	int knapsackLight(int v1, int w1, int v2, int w2, int m) {
		return (w1 + w2) <= m ? (v1 + v2) : (v1 >= v2 && w1 <= m) ? v1 : w2 <= m ? v2 : w1 <= m ? v1 : 0;
	}
}
