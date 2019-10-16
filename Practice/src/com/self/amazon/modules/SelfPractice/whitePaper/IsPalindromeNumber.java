package com.self.amazon.modules.SelfPractice.whitePaper;


public class IsPalindromeNumber{

	public static void main(String[] args){
		System.out.println(isPalindrome(8348));
	}

	private static boolean isPalindrome(int n){
	
		int i = 1;
		int m = n;
		while(m != 0){
			m = n/i;
			i*=10;
		}
		
		i /=100;
		
		if(i == 1) return true;
		
		while(n != 0 && i > 0){
			int r = n%10;
			int d = n/(i);
			
			n = n%i;
			if(i/100 > 0)
				n = n/10;
			
			i = i/100;
			if(r != d)
				return false;
		}		
		
		return true;
	}

}