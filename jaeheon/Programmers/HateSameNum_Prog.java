package Programmers;

import java.util.*;

public class HateSameNum_Prog {
//	public int[] solution(int[] arr) {
//
//		ArrayList<Integer> list = new ArrayList<>();
//		int tmp = 10;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != tmp) {
//				list.add(arr[i]);
//				tmp = arr[i];
//			}
//		}
//
//		int[] answer = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			answer[i] = list.get(i);
//		}
//
//		return answer;
//	}
	public int[] solution(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == stack.peek()) {
				continue;
			} else {
				stack.push(arr[i]);
			}
		}

		int[] answer = new int[stack.size()];

		int idx = stack.size() - 1;
		while (!stack.isEmpty()) {
			answer[idx--] = stack.pop();
		}

		return answer;
	}
}
