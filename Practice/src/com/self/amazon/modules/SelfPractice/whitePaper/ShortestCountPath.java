package com.self.amazon.modules.SelfPractice.whitePaper;



public class ShortestCountPath{

	public static void main(String[] args){
		int p = path(new int[][]{{1, 1, 1, 1}, {40, 1, 1, 1}, {50, 1, 20, 30}, {55, 1, 1, 15}/*{1, 5, 15, 3}, {1, 1, 1, 6}, {2, 16, 1, 4}, {9, 8, 1, 10}*/}, 0, 0);
		System.out.println(p);
	}
	
	public static int path(int[][] mesh, int x, int y){
			
		if(x == mesh.length -1 && y == mesh[0].length -1) 
			return mesh[x][y];
		
		
		if(x < mesh.length -1 && y < mesh[0].length -1)
			return Math.min(path(mesh, x + 1, y) + mesh[x][y], path(mesh, x, y + 1) + mesh[x][y]);
		
		if(x < mesh.length -1)
			return path(mesh, x + 1, y) + mesh[x][y];
		
		if(y < mesh.length -1)
			return path(mesh, x, y + 1) + mesh[x][y];
		
		return 0;
	}
}
