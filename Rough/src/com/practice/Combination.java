package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination {

	
	public static void main(String[] args) {
		
		int N = 3;
		int K = 1;
		int com = combine(N, K);
		System.out.println(com);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int combine(int N, int K){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<N; i++){
			list.add(i);	
		}
		
		Collection<List> per =  permute(list);
		Set set = new HashSet();
		for (List list2 : per) {
			
			Object[] l = list2.subList(K, N).toArray();
			Arrays.sort(l);
							
			if(!set.contains(Arrays.asList(l)))
				set.add(list2.subList(K, N));
		}
		
		return set.size();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Collection<List> permute(Collection integers){
		
		
		if(integers == null || (integers != null && integers.isEmpty())){
			List<Integer> list = new ArrayList<Integer>();
			List<List> list1 = new ArrayList<List>();
			list1.add(list);
			return list1;
		}
		
		List list = new ArrayList(integers);
		int head = (Integer) list.get(0);
		List<Integer> rest = list.subList(1, integers.size());
		
		
		List<List> result = (List<List>)permute(rest);
		
		
		List<List> output = new ArrayList<List>();
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j <= result.get(i).size(); j++) {
				List inter = new ArrayList<Integer>();
				inter.addAll((List)result.get(i));
				inter.add(j, head);
				output.add(inter);
			}
		}
		
		
		return output;
	}
	
}
