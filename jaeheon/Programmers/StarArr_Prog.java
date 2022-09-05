package Programmers;

//부분 수열 : 제거하거나 그러지 않고 원래 순서 유지해서 얻을 수 있는 새로운 수열
//교집합의 원소의 개수가 1이상
//부분 수열 중 가장 긴 스타 수열의 길이
//a : 1 ~ 500000

import java.util.*;

public class StarArr_Prog {
	public int solution(int[] a) {
		Map<Integer, Integer> hm = new HashMap<>();
		int answer = -1;

		for (int i : a) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		for (int key : hm.keySet()) {
			// System.out.println(key);
			if (hm.get(key) * 2 <= answer) {
				continue;
			}
			// System.out.println("continue" + " : " + key);
			int cnt = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] != a[i + 1] && (a[i] == key || a[i + 1] == key)) {
					// System.out.println(key + " // " + a[i] + " " + a[i + 1]);
					cnt += 2;
					i++;
				}
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
}
