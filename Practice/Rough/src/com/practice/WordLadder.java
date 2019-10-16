package com.practice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordLadder {

	static String[] dictionary = { "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN" };

	public static void main(String[] args) {
		String start = "TOON";
		String end = "PLEA";
		find(start, end, dictionary.length);
	}

	static void find(String start, String end, int n) {
		boolean[] v = new boolean[n];
		Queue<W> allLadders = new PriorityQueue<W>(new Comparator<W>() {
			@Override
			public int compare(W o1, W o2) {
				return o1.d - o2.d;
			}
		});
		Queue<W> q = new LinkedList<>();
		W w = new W(start, 0);
		w.words.add(start);
		q.add(w);
		Queue<W> qi = new LinkedList<>();
		while (true) {
			while (!q.isEmpty()) {
				W p = q.poll();
				qi = new LinkedList<>();
				for (int i = 0; i < n; i++) {
					String word = dictionary[i];
					if (!v[i] && word.compareTo(start) != 0 && isAdjacent(word, p.w)) {
						W ladder = new W(word, p.d + 1);
						ladder.words.addAll(p.words);
						ladder.words.add(word);
						if (word.compareTo(end) == 0)
							allLadders.add(ladder);
						else {
							qi.add(ladder);
							v[i] = true;
						}
					}
				}
			}
			if (!qi.isEmpty())
				q.addAll(qi);
			else
				break;
		}

		System.out.println(allLadders.poll().words);
	}

	static boolean isAdjacent(String w, String d) {
		char[] wordInString = w.toCharArray();
		char[] wordInDictionary = d.toCharArray();
		int c = 0, h = Math.max(wordInDictionary.length, wordInString.length);
		for (int i = 0; i < h; i++) {
			if (wordInDictionary[i] != wordInString[i])
				c++;
			if (c > 1)
				return false;
		}
		c += Math.abs(wordInDictionary.length - wordInString.length);
		if (c > 1)
			return false;
		return c == 1;
	}

	static class W {
		String w;
		int d = -1;
		List<String> words = new LinkedList<>();

		public W(String w, int d) {
			super();
			this.w = w;
			this.d = d;
		}
	}
}
