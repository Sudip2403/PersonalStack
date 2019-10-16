package com.practice.TopCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheCowDivTwo {


	
	public static void main(String[] args) {
		
		int N = 3;
		int K = 2;
		int com = find(N, K);
		System.out.println(com);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int find(int N, int K){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<N; i++){
			list.add(i);	
		}
		
		Collection<List> per =  permute(list, K);
		Set set = new HashSet();
		for (List list2 : per) {
			
			Object[] l = list2.subList(K, N).toArray();
			Arrays.sort(l);
							
			if(!set.contains(Arrays.asList(l))
					&& isMultiple(l, N))
				set.add(list2.subList(K, N));
		}
		
		return set.size() % 1000000007;
	}
	
	private static boolean isMultiple(Object[] list, int N){
		int sum = 0;
		boolean flag = false;
		for (Object object : list) {
			sum += (Integer)object;
		}
		if(sum % N == 0){
			flag = true;
		}
		return flag;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Collection<List> permute(Collection integers, int K){
		
		
		if(integers == null || (integers != null && integers.isEmpty())){
			List<Integer> list = new ArrayList<Integer>();
			List<List> list1 = new ArrayList<List>();
			list1.add(list);
			return list1;
		}
		
		List list = new ArrayList(integers);
		int head = (Integer) list.get(0);
		List<Integer> rest = list.subList(1, integers.size());
		
		List<List> result = null;
		//if(rest.size() < K){
			result = (List<List>)permute(rest, K);
		//}
		
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
