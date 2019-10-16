package com.self.amazon.modules.BitManipulation;

public class NumberOfOneBit_HammingWeight {

	public static void main(String[] args) {
		NumberOfOneBit_HammingWeight bit_HammingWeight = new NumberOfOneBit_HammingWeight();
		int n = bit_HammingWeight.hammingWeight(5);
		
		System.out.println(n);
	}
	
	public int hammingWeight(int n) {
	    System.out.println("----------------" + Integer.toBinaryString(n));
		int count = 0;
	    for(int i=1; i<33; i++){
	        if(getBit(n, i) == true){
	            count++;
	        }
	    }
	    return count;
	}
	 
	public boolean getBit(int n, int i){
	    return (n & (1 << i)) != 0;
	}
}
