package com.practice;

import java.util.ArrayList;
import java.util.List;

public class SquareSequence {

	public static void main(String[] args) {
		Integer[] a = new SquareSequence().SquareSequence(15);
		for (Integer i : a) {
			System.out.print(i + " ");
		}
	}
	Integer[] SquareSequence(int n) {
		for (int i = 1; i <= n; i++) {
			Integer[] p = SquareSequence(n, i);
			if(p.length == n)
				return p;
		}
		return new Integer[0];
	}
	Integer[] SquareSequence(int n, int a) {
	   List<Integer> r = new ArrayList<>();
	    while(a <= n){
	        boolean f = false;
	        for(int b = 1; b <= n; b++){
	            if(s(a+b) && !r.contains(a) && !r.contains(b) && a != b){
	                r.add(a);
	                a = b;
	                f = true;
	                break;
	            }
	        }
	        if(!f)
	        	return r.toArray(new Integer[r.size()]);
	    }
	    return r.toArray(new Integer[r.size()]);
	}

	boolean s(int k){
	    double r = Math.sqrt(k);
	    if(Math.ceil(r) == Math.floor(r))
	        return true;
	    return false;
	}
}
