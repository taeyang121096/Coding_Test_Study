package Programmers;

import java.util.*;

class DivideArr_Prog {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		if (list.isEmpty()) {
			list.add(-1);
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);

		return answer;
	}
}