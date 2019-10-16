package com.practice;

public class AlphaWinner {

	public static void main(String[] args) {
		String s = "zdqmwpbs";
		System.out.println(new AlphaWinner().alphaWinner(s));
	}

	String alphaWinner(String s) {
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		int[] l = { 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0 };
		int[] r = { 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		int a = 0, b = 0;
		for (char t : c) {
			if(!((t >= 97 && t <= 122) || (t >= 65 && t <= 90)))
				continue;
			a += l[t - 'a'];
			b += r[t - 'a'];
		}
		if (a > b)
			return "Left side wins!";
		if (b > a)
			return "Right side wins!";
		return "Let's fight again!";
	}

}
