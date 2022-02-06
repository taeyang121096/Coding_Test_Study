package Programmers;

//인접한 문자열 두개씩 제거
//스택 사용
//스택이 비어있으면 push
//peek하고 s의 다음글자가 같으면 pop
//peek하고 s의 다음글자가 다르면 push
//비어있으면 1, 아니면 0

import java.util.*;

class PairDelete_Prog {
	public int solution(String s) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.substring(i, i + 1));
			} else if (stack.peek().equals(s.substring(i, i + 1))) {
				stack.pop();
			} else {
				stack.push(s.substring(i, i + 1));
			}
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
}