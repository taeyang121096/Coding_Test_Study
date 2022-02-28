package Programmers;

import java.util.*;

class RightGalho_Prog {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		if (s.charAt(0) == ')') {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.size() > 0) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}

	}
}
