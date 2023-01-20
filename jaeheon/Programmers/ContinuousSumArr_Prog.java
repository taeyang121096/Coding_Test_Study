package Programmers;

import java.util.*;

public class ContinuousSumArr_Prog {
	public int solution(int[] elements) {

		Deque<Integer> dq = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < elements.length; i++) {
			dq.offer(elements[i]);
		}
		for (int i = 0; i < elements.length; i++) {
			int sum = 0;
			for (int j = 0; j < elements.length; j++) {
				int tmp = dq.poll();
				sum += tmp;
				dq.offer(tmp);
				// System.out.println(sum);
				set.add(sum);
			}
			dq.offer(dq.poll()); // 한바퀴 돌려줌
		}

		return set.size();
	}
}
