package Programmers;

import java.util.*;

class MoreSpicy_Prog {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i : scoville) {
			pq.offer(i);
		}

		while (pq.peek() < K) {
			if (pq.size() < 2) {
				return -1;
			}

			int first = pq.poll();
			int second = pq.poll();

			int tmp = first + (2 * second);

			pq.offer(tmp);
			answer++;
		}

		return answer;
	}
}