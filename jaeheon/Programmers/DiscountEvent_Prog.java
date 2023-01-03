package Programmers;

import java.util.*;

public class DiscountEvent_Prog {
	static Map<String, Integer> hm;

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		hm = new HashMap<>();

		int start = 0;
		int end = 9;

		// 일단 다 넣어줌
		for (String str : want) {
			hm.put(str, 0);
		}

		for (int i = 0; i < 10; i++) {
			hm.put(discount[i], hm.getOrDefault(discount[i], 0) + 1);
		}

		while (end < discount.length - 1) {
			if (end == 9 && check(want, number)) { // 처음부터 맞을경우
				answer++;
			}

			// 오른쪽으로 한칸씩 이동
			if (hm.containsKey(discount[start])) {
				hm.put(discount[start], hm.get(discount[start]) - 1);
			}
			start++;
			end++;
			if (hm.containsKey(discount[end])) {
				hm.put(discount[end], hm.get(discount[end]) + 1);
			}

			// 이동하고 체크
			if (check(want, number)) {
				answer++;
			}
		}

		return answer;
	}

	static boolean check(String[] want, int[] number) {
		for (int i = 0; i < want.length; i++) {
			if (hm.get(want[i]) != number[i]) {
				return false;
			}
		}
		return true;
	}
}
