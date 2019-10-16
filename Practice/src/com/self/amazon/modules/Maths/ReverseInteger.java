package com.self.amazon.modules.Maths;

public class ReverseInteger {

	public static void main(String[] args) {
		int r = reverse(123456789);
		System.out.println(r);
	}
	
	public static int reverse(int x) {
	    int rev = 0;
	    while(x != 0){
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	 
	    return rev;
	}
}
