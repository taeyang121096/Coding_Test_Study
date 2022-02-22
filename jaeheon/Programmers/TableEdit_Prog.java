package Programmers;

import java.util.*;

class TableEdit_Prog {
	public String solution(int n, int k, String[] cmd) {
		String answer = "";
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int size = n;

		for (String c : cmd) {
			String str[] = c.split(" ");
			if (str[0].equals("D")) {
				k += Integer.parseInt(str[1]);
			} else if (str[0].equals("U")) {
				k -= Integer.parseInt(str[1]);
			} else if (str[0].equals("C")) {
				stack.push(k); // 스택에 넣고
				size--; // 사이즈 줄이고
				if (k == size) { // 가장 마지막 행이면
					k--; // 바로 윗 행 선택
				}
			} else if (str[0].equals("Z")) {
				int tmp = stack.pop();
				if (tmp <= k) {
					k++;
				}
				size++;
			}
		}

		for (int i = 0; i < size; i++) {
			sb.append("O");
		}
		while (!stack.isEmpty()) {
			sb.insert(stack.pop(), "X");
		}

		return sb.toString();
	}
}