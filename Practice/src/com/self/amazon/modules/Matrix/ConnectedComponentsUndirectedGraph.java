package com.self.amazon.modules.Matrix;

public class ConnectedComponentsUndirectedGraph {

	public static void main(String[] args) {
		ConnectedComponentsUndirectedGraph graph = new ConnectedComponentsUndirectedGraph();
		graph.countComponents(5, new int[][]{{0,1}, {1,2}, {3,4}});
		
	}
	
	public int countComponents(int n, int[][] edges) {
	    int count = n;
	 
	    int[] root = new int[n];
	    // initialize each node is an island
	    for(int i=0; i<n; i++){
	        root[i]=i;        
	    }
	 
	    for(int i=0; i<edges.length; i++){
	        int x = edges[i][0];
	        int y = edges[i][1];
	 
	        int xRoot = getRoot(root, x);
	        int yRoot = getRoot(root, y);
	 
	        if(xRoot!=yRoot){
	            count--;
	            root[xRoot]=yRoot;
	        }
	 
	    }
	 
	    return count;
	}
	 
	public int getRoot(int[] arr, int i){
	    while(arr[i]!=i){
	        arr[i]= arr[arr[i]];
	        i=arr[i];
	    }
	    return i;
	}
}
