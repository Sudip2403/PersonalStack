package com.self.amazon.modules.SelfPractice.whitePaper;



import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Primms{
	
	public static void main(String[] args){
		int[][] gr = new int[][]{{0, 3, 2, 0, 0}, {3, 0, 0, 5, 0}, {2, 0, 0, 1, 4}, {0, 5, 1, 0, 0}, {0, 0, 4, 0, 0}};
		List<Combin> map = minSpanningTree(gr);
		
		for(Combin entry: map){
			System.out.println(entry.v1 + " " + entry.v2);
		}
	}
	
	public static List<Combin> minSpanningTree(int[][] graph){
		if(graph == null) return null;
		
		int l = graph.length;
		PriorityQueue<VertexP> p = new PriorityQueue<VertexP>(l);
		p.offer(new VertexP(0, "0"));
		p.offer(new VertexP(Integer.MAX_VALUE, "1"));
		p.offer(new VertexP(Integer.MAX_VALUE, "2"));
		p.offer(new VertexP(Integer.MAX_VALUE, "3"));
		p.offer(new VertexP(Integer.MAX_VALUE, "4"));
		
		return findTree(graph, p);
		
	}
	
	private static List<Combin> findTree(int[][] graph, PriorityQueue<VertexP> p){
		int k = graph.length;
		List<Combin> map = new ArrayList<Combin>();
		
		while(!p.isEmpty()){
			VertexP v = p.poll();
			String name = v.name;

			for(int i = 0; i < k; i++){
				if(name.equals(String.valueOf(i))){
					for(int j = 0; j < k; j++){
						if(graph[i][j] > 0 && isMore(p, j, graph[i][j])){
							updateWeight(p, j, graph[i][j]);
							map.add(new Combin(String.valueOf(j), name));
						}
					}				
				}
			}
 
		}
		
		return map;
	}
	
	private static void updateWeight(PriorityQueue<VertexP> p, int i, int weight){
		List<VertexP> li = new ArrayList<VertexP>();
		
		while(!p.isEmpty()){
			VertexP q = p.poll();
			if(q.name.equals(String.valueOf(i))){
				q.weight = weight;
			}
			li.add(q);
		}
		
		p.addAll(li);
	}
	
	private static boolean isMore(PriorityQueue<VertexP> p, int j, int weight){
		List<VertexP> li = new ArrayList<VertexP>();
		boolean f = false;
		
		while(!p.isEmpty()){
			VertexP q = p.poll();
			if(q.name.equals(String.valueOf(j))
					&& q.weight > weight){
				f = true;
			}
			li.add(q);
		}
		
		p.addAll(li);
		return f;
	}
}

class VertexP implements Comparable<VertexP>{

	int weight;
	String name;
	
	public VertexP(int weight, String name){
		this.weight = weight;
		this.name = name;
	}
	
	@Override
	public int compareTo(VertexP v){
		if(v.name.equals(name)) return 0;
		return weight > v.weight? 1: -1;
	}
	
}

class Combin{
	
	String v1;
	String v2;
	public Combin(String v1, String v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
	}
}