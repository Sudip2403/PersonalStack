package com.self.amazon.modules.SelfPractice.whitePaper;


public class Dikjstras{

	public static void main(String[] args){
		int[][] adjcMatr = new int[][]{{0, 3, 2, 0, 0}, {3, 0, 0, 5, 0}, {2, 0, 0, 1, 4}, {0, 5, 1, 0, 0}, {0, 0, 4, 0, 0}};
		Vertex[] V = dikjstrasSolve(adjcMatr);
		
		for(int i = 0; i < V.length; i++){
			System.out.print(V[i].getWeight() + " ");
		}
	}

	private static Vertex[] dikjstrasSolve(int[][] am){
		
		if(am == null) return null;
		
		Vertex[] V = new Vertex[am.length];
		for(int k = 0; k < am.length; k++)
			if(k == 0) 
				V[k] = new Vertex(0, false);
			else
				V[k] = new Vertex(Integer.MAX_VALUE, false);
		
		int m = am.length;
		int n = am[0].length;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(V[j].getWeight() > (am[i][j] + V[i].getWeight()) && !V[j].isVisited() && am[i][j] != 0)
					V[j].setWeight(V[i].getWeight() + am[i][j]);
					
			}
			V[i].setVisited(true);
		}
		
		return V;
	}
}

class Vertex{

	int weight;
	boolean visited;
	
	public Vertex(int weight, boolean visited){
		this. weight = weight;
		this.visited = visited;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
				
	public void setVisited(boolean visited){
		this.visited = visited;
	}

	public int getWeight(){
		return weight;
	}

	public boolean isVisited(){
		return visited;
	}

}

