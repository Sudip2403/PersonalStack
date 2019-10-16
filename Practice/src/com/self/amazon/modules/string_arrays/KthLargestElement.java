package com.self.amazon.modules.string_arrays;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
	
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}
}

