package com.practice.TopCoder;

import java.util.HashSet;
import java.util.Set;

//In the city, roads are arranged in a grid pattern. Each point on the grid represents a corner where two blocks meet. 
//The points are connected by line segments which represent the various street blocks. 
//Using the cartesian coordinate system, we can assign a pair of integers to each corner as shown below. 


//You are standing at the corner with coordinates 0,0. Your destination is at corner width,height. 
//You will return the number of distinct paths that lead to your destination. Each path must use exactly width+height blocks. 
//In addition, the city has declared certain street blocks untraversable. These blocks may not be a part of any path. 
//You will be given a String[] bad describing which blocks are bad. If (quotes for clarity) "a b c d" is an element of bad, 
//it means the block from corner a,b to corner c,d is untraversable. For example, let's say
//width  = 6
//length = 6
//bad = {"0 0 0 1","6 6 5 6"}


public class AvoidRoads {

	public static void main(String[] args) {
		int width = 2;
		int height = 2;
		String[] bad = {};
		
		new AvoidRoads().numWays(width, height, bad);
	}
	
	public long numWays(int width, int height, String[] bad){
		long numberOfPaths = 0;
		Set<String> paths = new HashSet<String>();
		String path = "";
		int x = 0;
		int y = 0;
		
		while(!(x >= width && y >= height)){
			
			if(x+1 <= width && y <= height && !paths.contains(String.valueOf(x+1)+String.valueOf(y)))
				path = path + String.valueOf(x++)+String.valueOf(y);
			
			else if(x <= width && y+1 <= height && !paths.contains(String.valueOf(x)+String.valueOf(y+1)))
				path = path + String.valueOf(x)+String.valueOf(y++);
			
			else if(x+1 <= width && y+1 <= height && !paths.contains(String.valueOf(x+1)+String.valueOf(y+1)))
				path = path + String.valueOf(x++)+String.valueOf(y++);
			
		}
		paths.add(path+width+height);
		
		return numberOfPaths;
	}
	
	private void calcPath(int width, int height, String[] bad, Set<String> paths){
		String path = "";
		int x = 0;
		int y = 0;
		
		while(!(x >= width && y >= height)){
			
			if(x+1 <= width && y <= height && !paths.contains(String.valueOf(x+1)+String.valueOf(y)))
				path = path + String.valueOf(x++)+String.valueOf(y);
			
			else if(x <= width && y+1 <= height && !paths.contains(String.valueOf(x)+String.valueOf(y+1)))
				path = path + String.valueOf(x)+String.valueOf(y++);
			
			else if(x-1 <= width && y <= height && !paths.contains(String.valueOf(x-1)+String.valueOf(y)))
				path = path + String.valueOf(x--)+String.valueOf(y);
			
			else if(x <= width && y-1 <= height && !paths.contains(String.valueOf(x)+String.valueOf(y-1)))
				path = path + String.valueOf(x)+String.valueOf(y--);
			
		}
		paths.add(path+width+height);
	}
	 
}
