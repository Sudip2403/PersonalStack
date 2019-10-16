package com.self.amazon.modules.DynamicPrograming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("codeleet", new HashSet<String>(Arrays.asList(new String[]{"leet", "code"}))));
		
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
}