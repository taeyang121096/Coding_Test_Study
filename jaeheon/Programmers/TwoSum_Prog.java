package Programmers;

import java.util.*;

class TwoSum_Prog {
	public int[] solution(int[] numbers) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int tmp = numbers[i] + numbers[j];
				if (al.indexOf(tmp) < 0) {
					al.add(tmp);
				}
			}
		}

		int[] answer = new int[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}
		Arrays.sort(answer);

		return answer;
	}
}