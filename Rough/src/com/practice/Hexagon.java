package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	
You are given a puzzle with 7 pieces, each one of them a perfect hexagon. On each side of each hexagon there is a number, 1-6, and each hexagon has exactly one of each number.

You are supposed to assemble the pieces such that there is a center piece with the 6 other pieces surrounding it, and everywhere that two pieces touch, their touching sides must have the same number.

So for example, the following configuration is a solution to the puzzle, given the 7 pieces

  ___     ___     ___     ___     ___     ___     ___
 / 5 \   / 1 \   / 4 \   / 4 \   / 1 \   / 5 \   / 1 \
/2   4\ /6   3\ /3   1\ /2   5\ /6   5\ /4   3\ /6   2\
\3   6/ \2   5/ \5   2/ \6   1/ \4   2/ \2   6/ \5   3/
 \_1_/   \_4_/   \_6_/   \_3_/   \_3_/   \_1_/   \_4_/

       ___
      / 5 \
  ___/2   4\___
 / 5 \3   6/ 1 \
/4   3\_1_/6   3\
\2   6/ 1 \2   5/
 \_1_/6   2\_4_/
 / 1 \5   3/ 4 \
/6   5\_4_/3   1\
\4   2/ 4 \5   2/
 \_3_/2   5\_6_/
     \6   1/
      \_3_/
In this configuaration, the last piece is in the middle and the first through sixth pieces are placed in clockwise order from the top.

Note that even though in this case no rotation of the pieces was necessary, pieces may be rotated. So the middle piece could have been presented as

  ___
 / 6 \
/5   1\
\4   2/
 \_3_/
and the above configuration would still be legal. All that was necessary was to rotate the middle piece 1/6th of a turn counter-clockwise.

Given a String[] representing the 7 pieces, figure out all of the legal configurations and return a int[], sorted in ascending order, of the distinct indices (1-indexed) which appeared as the middle piece in one or more of these legal configurations.

Each element of the input will be 6 characters in length and will contain each of the characters '1' to '6', inclusive, exactly once. This is the order of the numbers on the piece, in clockwise order (as mentioned above, the starting point doesn't matter). You cannot flip the order, so 123456 cannot be considered as 654321 (it can, however, be considered as 234561, 345612, etc.)

 
Definition
    	
Class:	Hexagons
Method:	centers
Parameters:	String[]
Returns:	int[]
Method signature:	int[] centers(String[] pieces)
(be sure your method is public)
    
 
Constraints
-	pieces has exactly 7 elements
-	each element of pieces has length 6
-	each element of pieces contains each of the characters '1' to '6', inclusive, exactly once.
 
Examples
0)	
    	
{"546132","135426","412653","451362","152346","536124","123456"}

Returns: { 7 }
This is the above example, where the last (7th) piece is the only legal center.
1)	
    	
{"123654","123654","513624","654123","625314","541236","324615"}
Returns: { 1,  2,  4,  6 }
Notice that pieces 1, 2, 4 and 6 are in fact all the same piece. The puzzle has a solution with this piece at its center, for example the following configuration of pieces (1-indexed):
  7   2
6   1   3
  5   4
2)	
    	
{"512634","152364","243516","612345","152643","342165","321456"}
Returns: { }

 */
public class Hexagon {

	
	static int top = 3;
	static int topRight = 4;
	static int bottomRight = 5;
	static int bottom = 0;
	static int topLeft = 2;
	static int bottomLeft = 1;
	
	
	public static void main(String[] args) {
		int[] arr = centers(new String[]{"123654","123654","513624","654123","625314","541236","324615"});
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static int[] centers(String[] pieces){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < pieces.length; i++) {
			String[] remP = new String[6];
			int c = 0;
			for (int j = 0; j < pieces.length; j++) {
				if(i==j)continue;
				else{
					remP[c] = pieces[j];
					c++;
				}
			}
			String p = pieces[i];
			for (int j = 0; j < p.length(); j++) {
				String pR = rotate(p, j);
				boolean t = match(pR, remP, new HashMap<>(), "T", false);
				if(t){
					list.add(i+1);
					break;
				}
			}
		}
		
		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	
	static boolean match(String center, String[] pieces, Map<Integer, Character> map, String pos, boolean m){
		if(pieces.length == 0) return true;
		
		if(!m && pieces.length > 0){
			//fit at the top
			if(pos.equals("T") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(0), top);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(4, center.charAt(1));
						map.put(5, p.charAt(2));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						noneMatch = false;
						m = match(center, arr, map, "TR", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
			
			//fit at the top right
			if(pos.equals("TR") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(1), topRight);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(5, center.charAt(2));
						map.put(0, p.charAt(3));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						m = match(center, arr, map, "BR", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
			
			//fit at the bottom right
			if(pos.equals("BR") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(2), bottomRight);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(0, center.charAt(3));
						map.put(1, p.charAt(4));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						m = match(center, arr, map, "B", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
			
			//fit at the bottom
			if(pos.equals("B") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(3), bottom);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(1, center.charAt(4));
						map.put(2, p.charAt(5));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						m = match(center, arr, map, "BL", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
			
			//fit at the bottom left
			if(pos.equals("BL") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(4), bottomLeft);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(2, center.charAt(5));
						map.put(3, p.charAt(0));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						m = match(center, arr, map, "TL", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
			
			//fit at the top left
			if(pos.equals("TL") && pieces.length > 0){
				boolean noneMatch = true;
				for (int i = 0; i < pieces.length; i++) {
					if(m) return true;
					boolean mat = true;
					String p = pieces[i];
					p = rotateToMatch(p, center.charAt(5), topLeft);
					if(!map.isEmpty()){
						for (Integer it : map.keySet()) {
							if(p.charAt(it) != map.get(it)){
								mat = false;
								break;
							}
						}
					}
					if(mat){
						map = new HashMap<Integer, Character>();
						map.put(3, center.charAt(0));
						map.put(4, p.charAt(1));
						String[] arr = new String[pieces.length-1];
						int c = 0;
						for (int j = 0; j < pieces.length; j++) {
							if(i==j)continue;
							else{
								arr[c] = pieces[j];
								c++;
							}
						}
						m = match(center, arr, map, "T", m);
					}
				}
				if(noneMatch && !m)
					return false;
			}
		}
		return m;
	}
	
	static String rotateToMatch(String str, char matchInt, int matchIndex){
		String s = str;
		for (int i = 1; i < str.length(); i++) {
			if(s.charAt(matchIndex) == matchInt)
				break;
			s = rotate(str, i);
		}
		return s;
	}
	
	static String rotate(String str, int n){
		String pre = str.substring(0, n);
		String post = str.substring(n, str.length());
		return post+pre;
	}
}
