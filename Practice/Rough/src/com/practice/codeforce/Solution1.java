package com.practice.codeforce;

import java.io.IOException;
import java.util.Scanner;

public class Solution1 {

	public static int check(int n) {
		return n + 1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			int result = check(n);
			System.out.println(result);
		}
		scanner.close();
	}
}