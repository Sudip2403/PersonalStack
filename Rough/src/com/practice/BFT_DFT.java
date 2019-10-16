package com.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFT_DFT {

	
	public static void main(String[] args) {
		//Adjecency matrix 
		List<List<Integer>> graph = createBfsAdjacencyMatrix();
		System.out.println("Breadth first traversal - " + bfs(graph));
		
		List<List<Integer>> graph1 = createDfsAdjacencyMatrix();
		System.out.println("Depth first traversal - " + dfs(graph1));
		
 	}
	
	private static List<List<Integer>> createBfsAdjacencyMatrix(){
		List<List<Integer>> adjMatr = new ArrayList<List<Integer>>();
		
		adjMatr.add(Arrays.asList(new Integer[]{2, 3, 10}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 4, 6}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 4, 5}));
		adjMatr.add(Arrays.asList(new Integer[]{2, 3, 6}));
		adjMatr.add(Arrays.asList(new Integer[]{3, 7, 10}));
		adjMatr.add(Arrays.asList(new Integer[]{2, 4, 7}));
		adjMatr.add(Arrays.asList(new Integer[]{6, 8}));
		adjMatr.add(Arrays.asList(new Integer[]{7, 9}));
		adjMatr.add(Arrays.asList(new Integer[]{8}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 5}));
				
		return adjMatr;
	}
	
	private static List<List<Integer>> createDfsAdjacencyMatrix(){
		List<List<Integer>> adjMatr = new ArrayList<List<Integer>>();
		
		adjMatr.add(Arrays.asList(new Integer[]{2, 3, 4}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 6}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 5}));
		adjMatr.add(Arrays.asList(new Integer[]{1, 5, 6}));
		adjMatr.add(Arrays.asList(new Integer[]{3, 4, 6, 7, 9}));
		adjMatr.add(Arrays.asList(new Integer[]{2, 4, 5, 7, 8}));
		adjMatr.add(Arrays.asList(new Integer[]{5, 6, 8}));
		adjMatr.add(Arrays.asList(new Integer[]{6, 7, 9}));
		adjMatr.add(Arrays.asList(new Integer[]{5, 8}));
				
		return adjMatr;
	}
	
	private static List<Integer> bfs(List<List<Integer>> graph){
		Queue<Integer> queue = new ArrayDeque<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		queue.add(1);
		visitedNodes.add(1);
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			if(!visitedNodes.contains(node))
				visitedNodes.add(node);
			List<Integer> connectedNodes = graph.get(node -1);
			for (Integer o : connectedNodes) {
				if(!visitedNodes.contains(o)){
					queue.add(o);
				}
			}
		}
		
		return visitedNodes;
	}
	
	private static List<Integer> dfs(List<List<Integer>> graph){
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		stack.push(1);
		visitedNodes.add(1);
        Integer temp = 1;
	
        while (!stack.isEmpty()) {
            temp = stack.peek();   
            boolean found = false;
			
            for(Integer vertex : graph.get(temp-1)){
                if(!visitedNodes.contains(vertex)){
                	visitedNodes.add(vertex);
                	stack.push(vertex);
                    found = true;
                    break;
                }
            }
			
            if(!found){
                temp = stack.pop();
            }
        }
		return visitedNodes;
	}
}
