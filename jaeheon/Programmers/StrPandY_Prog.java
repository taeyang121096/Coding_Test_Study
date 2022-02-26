package Programmers;

import java.util.*;

class StrPandY_Prog {
	boolean solution(String s) {

		Stack<String> stackP = new Stack<>();
		Stack<String> stackY = new Stack<>();

		s = s.toLowerCase();

		String[] str = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			str[i] = s.substring(i, i + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (str[i].equals("p")) {
				stackP.push(str[i]);
			} else if (str[i].equals("y")) {
				stackY.push(str[i]);
			}
		}

		if (stackP.size() == stackY.size()) {
			return true;
		} else {
			return false;
		}

	}
}
