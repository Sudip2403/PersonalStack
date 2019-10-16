package com.self.amazon.modules.SelfPractice;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {

	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
/*		int[] d = new int[]{6, 2, 7, 14, 3, 12, 9, 4, 8, 10, 5};
		heapify(d);

		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
*/
		add(6);
		add(2);
		add(7);
		add(14);
		add(3);
		add(12);
		add(9);
		add(4);
		add(8);
		add(10);
		add(5);
		
		System.out.println(pop());
		System.out.println(pop());
		
		add(20);
		
		System.out.println(pop());
	}
	
	private static void heapify(int[] data){
		int n = data.length;
		int  a = 0;
		
		for (int i = n -1; i >= 0; i--) {
			if(i%2 != 0)
				a = i/2;
			else
				a = i/2 -1;
				
			if(a >= 0 && data[i] > data[a]){
				int temp = data[i];
				data[i] = data[a];
				data[a] = temp;
				heapify(data);
			}
		}
	}
	
	
	private static void heap(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}
	}
	
	private static void heap(){
		int[] arr = new int[queue.size()];
		
		int c = 0;
		while(!queue.isEmpty()){
			arr[c] = queue.poll();
			c++;		
		}
		
		heapify(arr);
		heap(arr);
	}
	
	public static int pop(){
		int p = queue.poll();
		heap();
		return p;
	}
	
	public static void add(int n){
		queue.add(n);
		heap();
	}
}
