package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an undirected graph G having N (1<N<=1000) vertices and positive weights. Find the shortest path from vertex 1 to vertex N, or state that such path doesn’t exist.
public class ShortestPath_Dikjstras {
	
	public static void main(String[] args) {
		List<WeightedSubGraph> graph = new ArrayList<WeightedSubGraph>();
		Map<String, Integer> weightedGraphMap = new HashMap<String, Integer>();
		
		graph.add(new WeightedSubGraph("AB", 2));
		graph.add(new WeightedSubGraph("BC", 3));
		graph.add(new WeightedSubGraph("CD", 4));
		graph.add(new WeightedSubGraph("DF", 5));
		graph.add(new WeightedSubGraph("FE", 6));
		graph.add(new WeightedSubGraph("EA", 1));
		graph.add(new WeightedSubGraph("ED", 1));
		graph.add(new WeightedSubGraph("AD", 1));
		
		String startNode = "A";
		String endNode = "D";
		List<PathValue> pathValue = new ArrayList<PathValue>();
		PathValue pathshort = new PathValue("", 1000);
		
		Map<String, Nodes> nodeMap = createNodeGraph(graph, weightedGraphMap);
		nodeMap.get(startNode).setVerticeWeight(0);
		getAllAdjacentNodes(startNode, startNode, endNode, weightedGraphMap, nodeMap, "", 0, pathValue);
		
		for (PathValue pathValue2 : pathValue) {
			if(pathValue2.getWeight() < pathshort.getWeight()){
				pathshort = new PathValue(pathValue2.getPath(), pathValue2.getWeight());
			}
		}
		
		System.out.println("Shortest Path - " + pathshort.getPath() + "   Weight - " + pathshort.getWeight());
	}

	private static void getAllAdjacentNodes(String graphStartNode, String startNode, String endNode, Map<String, Integer> weightedGraphMap, Map<String, Nodes> nodeMap, String pathValue, int currWeight, List<PathValue> shortestPath){
		if(!startNode.equals(endNode)){
			Nodes nodes = nodeMap.get(startNode);
			nodes.setVisited(true);
			for (String connectedNode : nodes.getNodesConnected()) {
				if(!nodeMap.get(connectedNode).isVisited()){
					
					if(null != weightedGraphMap.get(startNode+connectedNode)){
						currWeight = weightedGraphMap.get(startNode+connectedNode) + nodes.getVerticeWeight();
						if((weightedGraphMap.get(startNode+connectedNode) + nodes.getVerticeWeight()) < nodeMap.get(connectedNode).getVerticeWeight()){
							nodeMap.get(connectedNode).setVerticeWeight(weightedGraphMap.get(startNode+connectedNode) + nodes.getVerticeWeight());
						}
					}else {
						currWeight = weightedGraphMap.get(connectedNode+startNode) + nodes.getVerticeWeight();
						if((weightedGraphMap.get(connectedNode+startNode) + nodes.getVerticeWeight()) < nodeMap.get(connectedNode).getVerticeWeight()){
							nodeMap.get(connectedNode).setVerticeWeight(weightedGraphMap.get(connectedNode+startNode) + nodes.getVerticeWeight());
						}
					}
					if(!pathValue.contains(startNode))
						pathValue = pathValue + startNode;
					getAllAdjacentNodes(graphStartNode, connectedNode, endNode, weightedGraphMap, nodeMap, pathValue, currWeight, shortestPath);
				}
			}
		}else{
			shortestPath.add(new PathValue(pathValue+endNode, currWeight));
			System.out.println("Path - " + pathValue+endNode + "   Final Weight - " + currWeight);
			pathValue = "";
		}
	}
	
	private static Map<String, Nodes> createNodeGraph(List<WeightedSubGraph> graph, Map<String, Integer> weightedGraphMap){
		Map<String, Nodes> nodesMap = new HashMap<String, Nodes>();
		for (WeightedSubGraph subGraph : graph) {
			weightedGraphMap.put(subGraph.getEdge(), subGraph.getWeight());
			Nodes nodes1 = null;
			Nodes nodes2 = null;
			int count = 1;
			for (char vertex : subGraph.getEdge().toCharArray()) {
				if(count == 1)
					nodes1 = new Nodes(vertex, 1000, false);
				else if(count == 2)
					nodes2 = new Nodes(vertex, 1000, false);
				count++;
			}
			
			if(null == nodesMap.get(String.valueOf(nodes1.getVertex()))){
				nodes1.getNodesConnected().add(String.valueOf(nodes2.getVertex()));
				nodesMap.put(String.valueOf(nodes1.getVertex()), nodes1);
			}else{
				nodesMap.get(String.valueOf(nodes1.getVertex())).getNodesConnected().add(String.valueOf(nodes2.getVertex()));
			}
			
			if(null == nodesMap.get(String.valueOf(nodes2.getVertex()))){
				nodes2.getNodesConnected().add(String.valueOf(nodes1.getVertex()));
				nodesMap.put(String.valueOf(nodes2.getVertex()), nodes2);
			}else{
				nodesMap.get(String.valueOf(nodes2.getVertex())).getNodesConnected().add(String.valueOf(nodes1.getVertex()));
			}
		}
		return nodesMap;
	}
}



class WeightedSubGraph{
	String edge;
	
	int weight;

	public WeightedSubGraph(String edge, int weight) {
		super();
		this.edge = edge;
		this.weight = weight;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}

class Nodes{
	char vertex;
	int verticeWeight = 1000;
	boolean visited = false;
	
	List<String> nodesConnected;
	
	List<PathValue> paths;
	
	public Nodes(int verticeWeight, boolean visited) {
		super();
		this.verticeWeight = verticeWeight;
		this.visited = visited;
	}

	public Nodes(char vertex, int verticeWeight, boolean visited) {
		super();
		this.vertex = vertex;
		this.verticeWeight = verticeWeight;
		this.visited = visited;
	}
	
	public List<PathValue> getPaths() {
		if(paths == null)
			paths = new ArrayList<PathValue>();
		return paths;
	}

	public List<String> getNodesConnected() {
		if(nodesConnected == null)
			nodesConnected = new ArrayList<String>();
		return nodesConnected;
	}

	public char getVertex() {
		return vertex;
	}
	public void setVertex(char vertex) {
		this.vertex = vertex;
	}
	public int getVerticeWeight() {
		return verticeWeight;
	}
	public void setVerticeWeight(int verticeWeight) {
		this.verticeWeight = verticeWeight;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}

class PathValue{
	String path;
	Integer weight;
	public PathValue(String path, Integer weight) {
		super();
		this.path = path;
		this.weight = weight;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}

