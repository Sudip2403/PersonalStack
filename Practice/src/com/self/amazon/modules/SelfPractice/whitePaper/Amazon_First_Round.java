package com.self.amazon.modules.SelfPractice.whitePaper;

//Input 2 strings
//Output boolean
//Non case sensitive
//Could be space & puctuations

//example - s1 -brown cat 
//s2 - bc
//unique chars
//s1 = abc ; s2 = ab

//s1 = "", s2= "abfs"
//s1 = "asf", s2= ""
//s1 = null; s2 =""
//s1 = null; s2 =null
//s1 = "ascfgdsww" s2 = "ascf"
//s1 = "ascfgdsww" s2 = "ascfdrrvbse"
//s1 = "ab" s2 = "deuarvetqwertyuioiab"
//s1="add sum" s2="duke manhattan"
//s1="AADDD" s2="aaddd"
//s1="adv-it" s2="adv-it"
//s1="advit23" s2="adv-it2345"

//s1="aaaa" s2="abcd"
//s1="aaaa" s2="aaaaaaaaaabcd"

public class Amazon_First_Round{

	public static void main(String[] args) {
			System.out.println(match("aaaa", "aaaaaaaa"));
	}
	
 public static boolean match(String s1, String s2){
     if(s1 == null || s2 == null) return false;
     
     int[] arr = new int[26];
     
     for(int i =0; i < s1.length(); i++){
         arr[s1.charAt(i) - 'a']++;
     }
     
     int i = s2.length();
     while(i > 0){
    	 if(arr[s2.charAt(--i) - 'a'] == 0)
    		 return false;
     }
     /*for(int j = 0; j < s2.length(); j++){
         if(arr[j] == 0)
             return false;
         //if(arr[j] > 0)
         //    arr[j]--;
     }*/
     
     return true;
 }

}
