package com.self.amazon.modules.SelfPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordTransitDictionary {

	public static void main(String[] args) {
		
		List<String> dict = new ArrayList<String>(Arrays.asList(new String[] {"dig", "bbc", "dat", "hot",  "dot", "aaa"}));
		
		Set<String> t = new HashSet<String>();
		
		dictPath("cat", "dog", dict, t, 0, 0);
		
		System.out.println(t);
	}
	
	private static void dictPath(String startWord, String endWord, List<String> dict, Set<String> traverse, int startIndex, int letStartIndex){
		
		if(dict.contains(startWord))
			traverse.add(startWord);
		
		if(startWord.equals(endWord))
			return;
		
		for (int i = 0; i < startWord.length(); i++) {
			if(endWord.charAt(i) == startWord.charAt(i))
				continue;
			
			if(endWord.charAt(letStartIndex) == startWord.charAt(letStartIndex))
				startIndex = 0;
			
			for (int j = 'a' + startIndex; j <= 'z'; j++) {
				if(startWord.charAt(i) != (char)j){
					String f = startWord.substring(0, i);
					String l = startWord.substring(i + 1);
					startWord = f + (char)j + l;
					dictPath(startWord, endWord, dict, traverse, j + 1, i);
				}
			}
		}
	}
	
}
