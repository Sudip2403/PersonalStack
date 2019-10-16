package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A palindrome is a String that is spelled the same forward and backwards. Given a String base that may or may not be a palindrome, 
 * we can always force base to be a palindrome by adding letters to it. For example, given the word "RACE", we could add the letters "CAR" to its back to get "RACECAR" (quotes for clarity only). However, we are not restricted to adding letters at the back. For example, we could also add the letters "ECA" to the front to get "ECARACE". In fact, we can add letters anywhere in the word, so we could also get "ERCACRE" by adding an 'E' at the beginning, a 'C' after the 'R', and another 'R' before the final 'E'. Your task is to make base into a palindrome by adding as few letters as possible and return the resulting String. When there is more than one palindrome of minimal length that can be made, return the lexicographically earliest (that is, the one that occurs first in alphabetical order).

 
Definition
    	
Class:	ShortPalindromes
Method:	shortest
Parameters:	String
Returns:	String
Method signature:	String shortest(String base)
(be sure your method is public)
    
 
Constraints
-	base contains between 1 and 25 characters, inclusive.
-	Every character in base is an uppercase letter ('A'-'Z').
 
Examples
0)	
    	
"RACE"
Returns: "ECARACE"
To make "RACE" into a palindrome, we must add at least three letters. However, there are eight ways to do this by adding exactly three letters:
    "ECARACE"  "ECRARCE"  "ERACARE"  "ERCACRE"
    "RACECAR"  "RAECEAR"  "REACAER"  "RECACER"
Of these alternatives, "ECARACE" is the lexicographically earliest.
1)	
    	
"TOPCODER"
Returns: "REDTOCPCOTDER"
2)	
    	
"Q"
Returns: "Q"
3)	
    	
"MADAMIMADAM"
Returns: "MADAMIMADAM"
4)	
    	
"ALRCAGOEUAOEURGCOEUOOIGFA"
Returns: "AFLRCAGIOEOUAEOCEGRURGECOEAUOEOIGACRLFA"

 */
public class ShortPalindromes {

	
	public static void main(String[] args) {
		System.out.println(shortest("TOPCODER"));
	}
	
	static String shortest(String base){
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < base.length(); i++) {
			if(map.containsKey(base.charAt(i)))
				map.get(base.charAt(i)).add(i);
			else{
				List<Integer> l = new ArrayList<>();
				l.add(i);
				map.put(base.charAt(i), l);
			}
		}
		
		
		List<String> palindromes = new ArrayList<>();
		for (Character c : map.keySet()) {
			List<Integer> l = map.get(c);
			if(l.size() > 1){
				for (int i = 0; i < l.size()-1; i++) {
					String str = base.substring(l.get(i), l.get(i+1)+1);
					List<String> p = createPalindrome(str, new ArrayList<>(), str);
					String pre = base.substring(0, l.get(i));
					String post = base.substring(l.get(i+1) +1, base.length());
					for (String s : p) {
						palindromes.addAll(createPalindrome(pre+s+post, palindromes, str));
					}
				}
			}
		}
		palindromes.addAll(createPalindrome(base, palindromes, base));
		Collections.sort(palindromes);
		if(palindromes.size() > 0)
			return palindromes.get(0);
		else
			return "";
	}
	
	static List<String> createPalindrome(String str, List<String> list, String o){
		if(null == str) return new ArrayList<>();
		if(str.length() == 1 || (str.length() == 2 && str.charAt(0) == str.charAt(1))){
			List<String> s = new ArrayList<>();
			s.add(str);
			return s;
		}
		
		if(!list.isEmpty()){
			for (String s : list) {
				if(s.length() < str.length())
					return list;
			}
		}else{
			int i = 0;
			int j = str.length()-1;
			boolean isPalin = true;
			o = str;
			while(j > i){
				if(str.charAt(i) != str.charAt(j)){
					String prebegin = str.substring(0, i);
					String postbegin = str.substring(i, str.length());
					list = createPalindrome(new String(prebegin+str.charAt(j)+postbegin), list, o);
		
					boolean f = true;
					if(!list.isEmpty()){
						for (String s : list) {
							if(s.length() <= str.length()){
								f = false;
								break;
							}
						}
					}
					if(f){
						String preend = str.substring(0, j);
						String postend = str.substring(j, str.length());
						list = createPalindrome(new String(preend+str.charAt(i)+postend), list, o);
					}
					isPalin = false;
				}
				i++;
				j--;
			}
			if(isPalin)
				list.add(str);
		}
		
		return list;
	}
	
}











