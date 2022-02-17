package Programmers;

import java.util.*;

class MaxAndMin_Prog {
	public String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			list.add(Integer.parseInt(str[i]));
		}

		Collections.sort(list);

		int min = list.get(0);
		int max = list.get(list.size() - 1);

		answer = min + " " + max;

		return answer;
	}
}