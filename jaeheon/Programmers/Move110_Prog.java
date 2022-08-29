package Programmers;

//x를 사전 순으로 앞에 오도록
//110을 빼서 삽입

//111보다는 왼쪽 나머지 보다는 오른쪽
//110을 제외한 문자열에서 0을 만나면 가장 마지막 0 뒤에
//0이 없으면 가장 왼쪽에

import java.util.*;

public class Move110_Prog {
	public String[] solution(String[] s) {
		String[] answer = new String[s.length];

		for (int i = 0; i < s.length; i++) {
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			for (int j = 0; j < s[i].length(); j++) {
				char ch3 = s[i].charAt(j);
				if (stack.size() >= 2) {
					char ch2 = stack.pop();
					char ch1 = stack.pop();
					if (ch1 == '1' && ch2 == '1' && ch3 == '0') {
						cnt++;
						continue;
					} else {
						stack.push(ch1);
						stack.push(ch2);
						stack.push(ch3);
					}
				} else {
					stack.push(ch3);
				}
			}
			// System.out.println(cnt);
			// System.out.println(stack.size());
			// System.out.println(stack);
			// System.out.println();

			int idx = stack.size();
			boolean flag = false;
			while (!stack.isEmpty()) {
				if (!flag) {
					if (stack.peek() == '1') {
						idx--;
					} else {
						flag = true;
					}
				}
				sb.insert(0, stack.pop());
			}
			while (cnt > 0) {
				sb.insert(idx, "110");
				idx += 3;
				cnt--;
			}
			answer[i] = sb.toString();
		}
		return answer;
	}
}
