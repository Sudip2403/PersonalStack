package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 	The digit d will appear in element i of ability if person i can perform task d. 
 * You are required to assign each of the given people to exactly one of the 6 tasks (numbered '0' through '5'). 
 * Two people cannot be assigned to the same task. Return the number of assignments possible. Two assignments differ if there is a person who is assigned a different task in each assignment.
 
Definition
    	
Class:	MatchCounts
Method:	howMany
Parameters:	String[]
Returns:	int
Method signature:	int howMany(String[] ability)
(be sure your method is public)
    
 
Constraints
-	ability will contain between 1 and 6 elements, inclusive.
-	Each element of ability will contain between 1 and 6 characters, inclusive.
-	Each character in ability will be a digit between '0' and '5', inclusive.
-	No character will appear more than once in a single element of ability.
 
Examples
0)	
    	
{"045"}
Returns: 3
Person 0 can perform 3 different tasks.
1)	
    	
{"01","23"}
Returns: 4
Two choices for person 0 and two choices for person 1.
2)	
    	
{"01","01"}
Returns: 2
Both people have two choices, but not all 2*2 possibilities are feasible.
3)	
    	
{"0","0"}
Returns: 0
4)	
    	
{"012345","012345","012345","012345","012345","012345"}
Returns: 720
 */
public class MatchCounts {

	public static void main(String[] args) {
		System.out.println(howMany(new String[]{"012345","012345","012345","012345","012345","012345"}));
	}
	
	static int howMany(String[] ability){
		if(null == ability) return 0;
		if(ability.length == 1) return ability[0].length();
		
		Set<List<Character>> set = new HashSet<>();
		for (int i = 0; i < ability.length; i++) {
			count(ability, i, new ArrayList<Character>(), set).size();
		}
		return set.size();
	}
	
	static Set<List<Character>> count(String[] a, int i, List<Character> tasksAlreadyTaken, Set<List<Character>> set){
		if(tasksAlreadyTaken.size() == a.length -1){
			String tasks = a[i];
			for (int j = 0; j < tasks.length(); j++) {
				if(!tasksAlreadyTaken.contains(tasks.charAt(j))){
					List<Character> l = new ArrayList<>();
					l.addAll(tasksAlreadyTaken);
					l.add(tasks.charAt(j));
					set.add(l);
					return set;
				}
			}
		}else{
			for (int j = 0; j < a[i].length(); j++) {
				tasksAlreadyTaken.add(a[i].charAt(j));
				if(i + 1 > a.length-1){
					set = count(a, i-1, tasksAlreadyTaken, set);
				}else{
					set = count(a, i+1, tasksAlreadyTaken, set);
				}
				tasksAlreadyTaken.remove(new Character(a[i].charAt(j)));
			}
		}
		
		return set;
	}
	
}










