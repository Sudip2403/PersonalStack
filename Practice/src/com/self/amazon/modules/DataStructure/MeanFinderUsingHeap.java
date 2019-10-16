package com.self.amazon.modules.DataStructure;

import java.util.PriorityQueue;

public class MeanFinderUsingHeap {

	PriorityQueue<Compare> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half
 
    public static void main(String[] args) {
    	MeanFinderUsingHeap finderUsingHeap = new MeanFinderUsingHeap();
    	finderUsingHeap.addNum(6);
    	finderUsingHeap.addNum(7);
    	finderUsingHeap.addNum(8);
    	finderUsingHeap.addNum(9);
    	finderUsingHeap.addNum(10);
    	finderUsingHeap.addNum(11);
    	finderUsingHeap.addNum(12);
    	finderUsingHeap.addNum(13);
    	finderUsingHeap.addNum(14);
    	
    	int m = (int) finderUsingHeap.findMedian();
    	System.out.println(m);
    	
	}
    
    public MeanFinderUsingHeap(){
        maxHeap = new PriorityQueue<Compare>();
        minHeap = new PriorityQueue<Integer>();
    }
 
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(new Compare(num));
        minHeap.offer(maxHeap.poll().a);
 
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(new Compare(minHeap.poll()));
        }
    }
 
    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek().a+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek().a;
        }
    }
}


class Compare implements Comparable<Compare>{

	Integer a;
	
	public Compare(Integer a) {
		super();
		this.a = a;
	}


	@Override
	public int compareTo(Compare b){
		return b.a - a;
	}
}