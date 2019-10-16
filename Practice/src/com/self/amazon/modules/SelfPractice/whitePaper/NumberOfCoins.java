package com.self.amazon.modules.SelfPractice.whitePaper;


import java.util.HashMap;
import java.util.Map;


public class NumberOfCoins{
	
	public static void main(String[] args){
		Map<Integer, Integer> numberOfCoins = numberOfCoins(new int[]{1, 2, 3, 5}, 10);
		
		for (int m = 1; m <= 10; m++){
			System.out.println("# of coins required for " + m + " = " + numberOfCoins.get(m));	
		}
	}
	
	private static Map<Integer, Integer> numberOfCoins(int[] den, int k){
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		countMap.put(0, 0);
		
		for(int i = 1; i <= k; i++){
			int coins = Integer.MAX_VALUE -1;
			for(int j = den.length -1; j >= 0; j--){
				Integer a = i >= den[j] && countMap.get(i - den[j]) != null? countMap.get(i - den[j]): Integer.MAX_VALUE -1;
				coins = Math.min(coins, (a + 1));
			}
			countMap.put(i, coins);
		}
		
		return countMap;
	}

}