package Programmers;

//옷의 조합의 개수

//clothes = [의상의 이름, 의상의 종류]
//같은 이름을 가진 의상은 없음 -> 그냥 곱하기
//의상의 수는 1 ~ 30
//하루에 최소 한개의 의상을 입음 -> -1

import java.util.*;

class Camo_Prog {
	public int solution(String[][] clothes) {
		Map<String, Integer> hm = new HashMap<>();

		int answer = 1;

		for (int i = 0; i < clothes.length; i++) {
			if (hm.get(clothes[i][1]) == null) {
				hm.put(clothes[i][1], 1);
			} else {
				hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
			}
		}

		for (String key : hm.keySet()) {
			answer *= (hm.get(key) + 1);
		}

		return answer - 1;
	}
}