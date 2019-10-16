package com.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinRangeKArrays {

	public static void main(String[] args) {
		int[] a = {5, 9, 13, 17};
		int[] b = {8, 10, 11};
		int[] c = {2, 3, 6, 7};
		findMinRange(a, b, c);
	}
	
	
	private static void findMinRange(int[]... arrays) {
	    if (arrays == null)
	        return;

	    int length = arrays.length;
	    int[] indices = new int[length];
	    int magnitude = Integer.MAX_VALUE - 1000;
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    Queue Q = new PriorityQueue();

	    // add the initial values in the queue
	    for (int i = 0; i < length; i++) {
	        int val = arrays[i][indices[i]];
	        if (val < min) min = val; if (val > max)
	            max = val;
	        Q.add(arrays[i][indices[i]]);
	    }

	    magnitude = max - min;
	    int tempMin = min;
	    int tempMax = max;
	    int tempMagnitude = tempMax - tempMin;
	    boolean exhausted = false;
	    do {
	        Integer minFromQueue = (Integer) Q.remove();
	        for (int i = 0; i < length; i++) { if (arrays[i][indices[i]] == minFromQueue) { indices[i]++; if (indices[i] >= arrays[i].length){
	                    exhausted = true;
	                    break;
	                }
					 
	                Q.add(arrays[i][indices[i]]);
	                if (tempMax < arrays[i][indices[i]]) {
	                    tempMax = arrays[i][indices[i]];
	                }
	                else {
	                    tempMin = (Integer) Q.peek();
	                }
	                tempMagnitude = tempMax - tempMin;
	                if (tempMagnitude < magnitude) {
	                    magnitude = tempMagnitude;
	                    min = tempMin;
	                    max = tempMax;
	                }
	                break;
	            }
	        }
	    } while (!exhausted);
	    System.out.println("Minimum Range is " + " " + min + " to " + max);
	}
}
