package Programmers;

//사람 1 ~ 50000
//몸무게, 무게제한 40 ~ 240
//한번에 무게제한 만큼만 태울 수 있음

//50 70 80
//50 + 80 = 130 > 100
//50 + 70 = 120 > 100
//50 + 50 = 100 = 100
import java.util.*;

class Boat_Prog {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Integer[] p = new Integer[people.length];
		for (int i = 0; i < people.length; i++) {
			p[i] = people[i];
		}

		Arrays.sort(p, Collections.reverseOrder());

		// for(int i = 0; i < p.length; i++){
		// System.out.println(p[i]);
		// }

		// 80 70 50 50
		int right = p.length - 1;

		for (int i = 0; i <= right; i++) {
			if (p[i] + p[right] > limit) { // 80 50
				answer++; // -> 70 50
			} else { // 50 50
				answer++;
				right--;
			}
		}

		return answer;
	}
}