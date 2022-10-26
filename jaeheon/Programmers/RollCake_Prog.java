package Programmers;

//동일한 가지수의 토핑을 맛볼 수 있도록

import java.util.*;

public class RollCake_Prog {
	public int solution(int[] topping) {
		int answer = 0;

		Map<Integer, Integer> hm = new HashMap<>();
		Map<Integer, Integer> hm1 = new HashMap<>();

		for (int i : topping) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		int tmp = 0;
		for (int i = 0; i < topping.length; i++) {
			tmp = topping[i];
			hm.put(tmp, hm.get(tmp) - 1);
			if (hm.get(tmp) == 0) {
				hm.remove(tmp);
			}
			hm1.put(topping[i], hm1.getOrDefault(topping[i], 0) + 1);

			if (hm.size() == hm1.size()) {
				answer++;
			}
		}

		return answer;
	}
}
