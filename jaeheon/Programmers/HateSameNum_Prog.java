package Programmers;

import java.util.*;

public class HateSameNum_Prog {
	public int[] solution(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();
		int tmp = 10;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != tmp) {
				list.add(arr[i]);
				tmp = arr[i];
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
