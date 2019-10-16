package com.practice;

public class LetterToNumber {

	public static void main(String[] args) {
		String a = "a2s&U5";
		System.out.println(new LetterToNumber().letterToNumber(a));
	}

	int letterToNumber(String a) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (c >= 65 && c <= 90)
				s.append((c - 'A' + 1));
			if (c >= 97 && c <= 122)
				s.append((c - 'a' + 27));
			if (c >= 48 && c <= 57)
				s.append(c);
		}
		String b = s.toString();
		int r = Integer.parseInt(b.charAt(0) + "");
		for (int i = 1; i < b.length(); i++) {
			int y = Integer.parseInt(b.charAt(i) + "");
			r = (r % 2 != 0) ? (r - y) : (r + y);
		}
		return r;
	}

}
