package Programmers;

//주어진 숫자에서 k개의 수를 제거해서 배열 생성
//가장 큰 수 리턴
//1 9 2 4
//9 4
//1 2 3 1 2 3 4
//3 2 3 4 
//k 3
//pop한 개수 세면 됨

import java.util.*;

class MakeBiggestNum_Prog {
	public String solution(String number, int k) {

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k > cnt) {
				stack.pop();
				cnt++;
			}
			stack.push(c);

		}
		while (cnt < k) {
			stack.pop();
			cnt++;
		}
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}

		return sb.toString();
	}
}