package com.practice;

public class MaxTriplet {

	public static void main(String[] args) {
		//int[] l = {1, 1, 1, 2, 2, 3, 3};
		//int m = 3;
		
		int[] l = new int[10000];
		int m = 9999;
		for (int i = 0; i < 10000; i++) {
			l[i] = i;
		}
		
		System.out.println(new MaxTriplet().maxTriplet(l, m));
		
	}
	
	int maxTriplet(int[] l, int m) {
	    int[] a = new int[m+1];
	    for(int k: l)
	        a[k]++;
	    return f(a, m, 0, 0, 0);
	}

	int f(int[] a, int m, int c, int p, int k){
	    if((k == m && a[k] < 3) || (k == m-1 && a[k+1] < 1)){
	        p = Math.max((k == m-1 && a[k] >= 3) ? (c + 1) : c, p);
	        return p;
	    }
	    for(int i = k; i <= m; i++){
	        if(a[i] >= 3){
	            a[i] -= 3;
	            p = Math.max(c + 1, f(a, m, c + 1, p, i));
	            a[i] += 3;
	        }
	        if(i > 0 && i + 1 <= m && a[i-1] > 0 && a[i] > 0 && a[i+1] > 0){
	            a[i] -= 1; a[i-1] -= 1; a[i+1] -= 1;
	            p = Math.max(c + 1, f(a, m, c + 1, p, i));
	            a[i] += 1; a[i-1] += 1; a[i+1] += 1;
	        }
	    }
	    return p;
	}
}
