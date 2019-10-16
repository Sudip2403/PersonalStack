package com.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SherlockAndGCD {

	// Complete the solve function below.
	static String solve(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (gcd(a[i], a[j]) == 1 && a[i] != a[j])
					return "YES";
			}
		}
		return "NO";
	}

	static long gcd(int a, int b) {
		int p = a > b ? a : b, q = a > b ? b : a;
		while (p % q != 0) {
			p = p % q;
			int t = p > q ? p : q;
			q = p > q ? q : p;
			p = t;
		}
		return q;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int aCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] a = new int[aCount];

			String[] aItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int aItr = 0; aItr < aCount; aItr++) {
				int aItem = Integer.parseInt(aItems[aItr]);
				a[aItr] = aItem;
			}

			String result = solve(a);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
