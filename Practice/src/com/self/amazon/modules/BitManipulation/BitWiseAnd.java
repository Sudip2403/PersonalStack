package com.self.amazon.modules.BitManipulation;

public class BitWiseAnd {

	public static void main(String[] args) {
		//int n = rangeBitwiseAnd(5, 7);
		//System.out.println(n);
		rangeBitwiseAnd(5, 7, 5,7);
		rangeBitwiseAnd(15, 27, 15,27);
		rangeBitwiseAnd(1, 4, 1,4);
		rangeBitwiseAnd(2, 700, 2,700);
	}
	
	public static void rangeBitwiseAnd(int m, int n, int a, int b) {
	     while (n > m) {
	          n = n & n - 1;
	     }
	     System.out.println("-----------------" +  (m & n));
	     
		
		for(int i = a; i < b; i++){
			a = a & (a + 1);
		}
		
		System.out.println("========================" +  a);
	}
}
