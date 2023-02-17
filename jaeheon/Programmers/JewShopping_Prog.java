package Programmers;

//진열대의 특정 범위 보석을 모두 구매
//모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 범위
//연속된 구간이어야 함
//시작 끝 번호를 리턴
//짧은 구간이 여러개면 시작 번호가 가장 작은 구간
//gems 1 ~ 100000

import java.util.*;

public class JewShopping_Prog {
	public int[] solution(String[] gems) {
		int[] answer = new int[2];

		Set<String> set = new HashSet<>(Arrays.asList(gems));
		Map<String, Integer> hm = new HashMap<>();

		int left = 0;
		int right = 0;
		int len = Integer.MAX_VALUE;

		while (true) {
			if (hm.size() == set.size()) { // left++
				hm.put(gems[left], hm.getOrDefault(gems[left], 0) - 1);
				if (hm.get(gems[left]) == 0) {
					hm.remove(gems[left]);
				}
				left++;
			} else if (right == gems.length) {
				break;
			} else { // right++
				if (right < gems.length) {
					hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
					right++;
				}
			}

			if (hm.size() == set.size() && right - left < len) {
				len = right - left;
				answer[0] = left + 1;
				answer[1] = right;
			}
		}

		return answer;
	}
}
