package com.practice.TopCoder;


public class TheLuckyString {

	int[] have = new int[26];

	int cnt = 0, L;

	
	public static void main(String[] args) {
		String s = "aba";
		System.out.println(new TheLuckyString().count(s));
	}

	
	
	void solve(int pos, char prev) {
		
		if (pos == L) {

			cnt++;
			return;

		}

		for (char c = 'a'; c <= 'z'; c++)

			if (prev != c && have[c - 'a'] > 0) {

				have[c - 'a']--;

				solve(pos + 1, c);

				have[c - 'a']++;

			}

	}

	public int count(String s) {

		L = s.length();

		for (int i = 0; i < L; i++)

			have[s.charAt(i) - 'a']++;

		solve(0, ' ');

		return cnt;

	}

}
