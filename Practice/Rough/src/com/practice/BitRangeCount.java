package com.practice;

public class BitRangeCount {

	/**
	 * Count all the 1 bits in the binary representation of all numbers in the
	 * range [m..n] (inclusive).
	 * 
	 * Inspired by evenBitCount, but more extreme.
	 * 
	 * [execution time limit] 3 seconds (java)
	 * 
	 * [input] integer64 m
	 * 
	 * The range's lower bound (inclusive)
	 * 
	 * 0 ≤ m ≤ n
	 * 
	 * [input] integer64 n
	 * 
	 * The range's upper bound (inclusive)
	 * 
	 * m ≤ n ≤ 2^47
	 * 
	 * [output] integer64
	 * 
	 * Total number of 1 bits in the binary representation of all numbers in
	 * range [m..n] inclusive. The result is guaranteed to be less than 2^53.
	 * 
	 */

	/**
	 * SOLUTION -
	 * 
	 * he way to solve these sorts of problems is to write out the first few
	 * values, and look for a pattern
	 * 
	 * Number binary # bits set F(n) 1 0001 1 1 2 0010 1 2 3 0011 2 4 4 0100 1 5
	 * 5 0101 2 7 6 0110 2 9 7 0111 3 12 8 1000 1 13 9 1001 2 15 10 1010 2 17 11
	 * 1011 3 20 12 1100 2 22 13 1101 3 25 14 1110 3 28 15 1111 4 32 It takes a
	 * bit of staring at, but with some thought you notice that the
	 * binary-representations of the first 8 and the last 8 numbers are exactly
	 * the same, except the first 8 have a 0 in the MSB (most significant bit),
	 * while the last 8 have a 1. Thus, for example to calculate F(12), we can
	 * just take F(7) and add to it the number of set bits in 8, 9, 10, 11 and
	 * 12. But that's the same as the number of set-bits in 0, 1, 2, 3, and 4
	 * (ie. F(4)), plus one more for each number!
	 * 
	 * # binary 0 0 000 1 0 001 2 0 010 3 0 011 4 0 100 5 0 101 6 0 110 7 0 111
	 * 
	 * 8 1 000 <--Notice that rightmost-bits repeat themselves 9 1 001 except
	 * now we have an extra '1' in every number! 10 1 010 11 1 011 12 1 100
	 * Thus, for 8 <= n <= 15, F(n) = F(7) + F(n-8) + (n-7). Similarly, we could
	 * note that for 4 <= n <= 7, F(n) = F(3) + F(n-4) + (n-3); and for 2 <= n
	 * <= 3, F(n) = F(1) + F(n-2) + (n-1). In general, if we set a =
	 * 2^(floor(log(n))), then F(n) = F(a-1) + F(n-a) + (n-a+1)
	 * 
	 * This doesn't quite give us an O(log n) algorithm; however, doing so is
	 * easy. If a = 2^x, then note in the table above that for a-1, the first
	 * bit is set exactly a/2 times, the second bit is set exactly a/2 times,
	 * the third bit... all the way to the x'th bit. Thus, F(a-1) = x*a/2 =
	 * x*2^(x-1). In the above equation, this gives us
	 * 
	 * F(n) = x*2x-1 + F(n-2x) + (n-2x+1) Where x = floor(log(n)). Each
	 * iteration of calculating F will essentially remove the MSB; thus, this is
	 * an O(log(n)) algorithm.
	 * 
	 */

	public static void main(String[] args) {
		long m = 7, n = 7;
		System.out.println(new BitRangeCount().bitRangeCount(m, n));
	}

	long bitRangeCount(long m, long n) {
		return f(n) - f(m == 0 ? 0 : m - 1);
	}

	long f(long n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		long x = (long) Math.log10(n);
		return (x * p(x - 1)) + (n - p(x) + 1) + f(n - p(x));
	}

	long p(long x) {
		return (long) Math.pow(2, x);
	}

}
