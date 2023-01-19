package Programmers;

import java.util.*;

public class Siso_Prog {
	public long solution(int[] weights) {
		long answer = 0;

		Map<Integer, List<Integer>> hm = new HashMap<>();

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < weights.length; i++) {
			set.add(weights[i]);
			if (!hm.containsKey(weights[i])) {
				List<Integer> al = new ArrayList<>();
				al.add(i);
				hm.put(weights[i], al);
			} else {
				hm.get(weights[i]).add(i);
			}
		}

		for (int key : set) {
			// 같을 때
			int size = hm.get(key).size();
			if (size > 1) {
				answer += ((long) size * (size - 1)) / 2;
			}

			// 2
			int w2 = key * 2;
			if (w2 % 3 == 0) {
				if (hm.containsKey(w2 / 3)) {
					answer += ((long) hm.get(w2 / 3).size() * hm.get(key).size());
				}
			}
			if (w2 % 4 == 0) {
				if (hm.containsKey(w2 / 4)) {
					answer += ((long) hm.get(w2 / 4).size() * hm.get(key).size());
				}
			}

			// 3
			int w3 = key * 3;
			if (w3 % 2 == 0) {
				if (hm.containsKey(w3 / 2)) {
					answer += ((long) hm.get(w3 / 2).size() * hm.get(key).size());
				}
			}
			if (w3 % 4 == 0) {
				if (hm.containsKey(w3 / 4)) {
					answer += ((long) hm.get(w3 / 4).size() * hm.get(key).size());
				}
			}

			// 4
			int w4 = key * 4;
			if (w4 % 2 == 0) {
				if (hm.containsKey(w4 / 2)) {
					answer += ((long) hm.get(w4 / 2).size() * hm.get(key).size());
				}
			}
			if (w4 % 3 == 0) {
				if (hm.containsKey(w4 / 3)) {
					answer += ((long) hm.get(w4 / 3).size() * hm.get(key).size());
				}
			}

			hm.remove(key);
		}

		return answer;
	}
}
