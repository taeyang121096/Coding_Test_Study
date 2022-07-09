package Programmers;

import java.util.*;

public class Lottos_Prog {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		HashMap<Integer, Integer> hm = new HashMap<>();

		int zeroCnt = 0;
		int cnt = 0;

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				zeroCnt++;
			} else {
				hm.put(lottos[i], i);
			}
		}

		for (int i = 0; i < 6; i++) {
			if (hm.containsKey(win_nums[i])) {
				cnt++;
			}
		}

		HashMap<Integer, Integer> res = new HashMap<>();
		res.put(6, 1);
		res.put(5, 2);
		res.put(4, 3);
		res.put(3, 4);
		res.put(2, 5);
		res.put(1, 6);
		res.put(0, 6);

		answer[0] = res.get(zeroCnt + cnt);
		answer[1] = res.get(cnt);

		return answer;
	}
}
