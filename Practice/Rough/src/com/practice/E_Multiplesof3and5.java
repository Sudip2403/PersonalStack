package com.practice;

import java.math.BigInteger;

public class E_Multiplesof3and5 {

	public static void main(String[] args) {
		long r = 0;
		for (int i = 1; i < 1000; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				r += i;
		}
		int a = 0, b = 1;
		r = 0;
		while(a <= 4000000){
			if(a % 2 == 0)
				r+= a;
			//System.out.print(a + ", ");
			int t = b;
			b = a + b;
			a = t;
		}
		
		BigInteger bb = BigInteger.ONE;
		for (int i = 1; i <= 100; i++) {
			bb = bb.multiply(new BigInteger(i+""));
		}
		int t = 0;
		while(bb.compareTo(BigInteger.ZERO) > 0){
			t += bb.mod(new BigInteger(10+"")).intValue();
			bb = bb.divide(new BigInteger(10+""));
		}

		
		BigInteger s = BigInteger.ZERO;
		for (int i = 1; i <= 10000; i++) {
			if(i == 1998 || i == 2997)
				continue;
			BigInteger m = BigInteger.ONE;
			if(i == 9)
				m = new BigInteger("1358"); 
			if(i == 99)
				m = new BigInteger("11335578"); 
			if(i == 999)
				m = new BigInteger("111333555778"); 
			if(i == 9999)
				m = new BigInteger("1111333355557778"); 
			
			String k = m.multiply(new BigInteger(""+i)).toString();
			while(k.contains("3") || k.contains("4") || k.contains("5") || k.contains("6") || k.contains("7") || k.contains("8") || k.contains("9")){
				m = m.add(BigInteger.ONE);
				k = m.multiply(new BigInteger(""+i)).toString();
			}
			System.out.println(i + "=" + m + ", ");
			s = s.add(m);
		}
		
		System.out.println(s);
	}
	
}
