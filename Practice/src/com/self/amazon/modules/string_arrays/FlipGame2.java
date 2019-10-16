package com.self.amazon.modules.string_arrays;

public class FlipGame2 {

	public static void main(String[] args) {
		FlipGame2 flipGame2 = new FlipGame2();
		System.out.println(flipGame2.canWin("++++++++"));
	}
	
	public boolean canWin(String s) {
	    if(s==null||s.length()==0){
	        return false;
	    }
	 
	   return canWinHelper(s.toCharArray()); 
	}
	 
	public boolean canWinHelper(char[] arr){
	    for(int i=0; i<arr.length-1;i++){
	        if(arr[i]=='+'&&arr[i+1]=='+'){
	            arr[i]='-';
	            arr[i+1]='-';
	 
	            boolean win = canWinHelper(arr);
	 
	            arr[i]='+';
	            arr[i+1]='+';
	 
	            //if there is a flip which makes the other player lose, the first play wins
	            if(!win){
	                return true;
	            }
	        }
	    }
	 
	    return false;
	}
}
