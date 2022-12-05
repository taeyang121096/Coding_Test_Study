package Programmers;

import java.util.*;

public class NextNum_Prog {
	public int solution(int[] common) {
		int answer = 0;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < common.length - 1; i++) {
			set.add(Math.abs(common[i + 1] - common[i]));
		}

		if (set.size() == 1) {
			answer = common[common.length - 1] + common[1] - common[0];
		} else {
			answer = common[common.length - 1] * (common[1] / common[0]);
		}

		return answer;
	}
}
