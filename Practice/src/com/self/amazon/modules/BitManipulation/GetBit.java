package com.self.amazon.modules.BitManipulation;

public class GetBit {

	public static void main(String[] args) {
		boolean f = getBit(10, 1);
		System.out.println(f);
		
	}
	
	public static boolean getBit(int num, int i){
		int result = num & (1<<i);
	 
		if(result == 0){
			return false;
		}else{
			return true;
		}
	}
}
