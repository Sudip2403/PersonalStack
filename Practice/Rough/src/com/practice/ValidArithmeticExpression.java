package com.practice;

import java.util.Stack;

public class ValidArithmeticExpression {

	public static void main(String[] args) {
		String a = ")))(((";
		System.out.println(new ValidArithmeticExpression().regularBracketSequence1(a));
	}

	boolean regularBracketSequence1(String a) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (c == '(')
				s.push('(');
			if (c == ')') {
				if (s.isEmpty())
					return false;
				char p = s.pop();
				if (p == ')')
					return false;
			}
		}
		if (!s.isEmpty())
			return false;
		return true;
	}

}
