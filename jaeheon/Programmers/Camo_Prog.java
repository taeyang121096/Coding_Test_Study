package Programmers;

//clothes = [의상의 이름, 의상의 종류]
//같은 이름을 가진 의상은 없음 -> 그냥 곱하기
//의상의 수는 1 ~ 30
//하루에 최소 한개의 의상을 입음 -> -1

//의상 -> 2차원 배열
//모든 옷의 조합의 수 구해라
//아무것도 안입을 수는 없음
//-> 옷을 2벌, 바지를 2벌, 신발을 2켤레 가지고 있다면
//3 * 3 * 3 - 1(누드) 가 답이 됨

import java.util.*;

class Camo_Prog {
	public int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if (hm.get(clothes[i][1]) == null) {
				hm.put(clothes[i][1], 1);
			} else {
				hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
			}
		}

		for (String str : hm.keySet()) {
			answer *= (hm.get(str) + 1);
		}

		return answer - 1;
	}
}