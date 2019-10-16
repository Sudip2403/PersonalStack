package com.self.amazon.modules.linkedList;

public class CheckIfPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(878));
	}
	
	private static boolean isPalindrome(int n){
		int i = 1;
		int p = n;
		
		while(p != 0){
			i *= 10;
			p = n/i;
		}
		
		
		if(i == 1)
			return true;
		
		while(i > 1){
			int b = n%(i/10);
			int a = n/(i/10);
			n = a/(i/10);
			n = n%(i/10);
			
			i /= 10;
			
			if(a != b)
				return false;
		}
		
		return true;
	}
}
