package Programmers;

//각 큐의 합을 모든 원소 합 / 2로 만들기
//절반을 만드는데 드는 최소 횟수

import java.util.*;

public class MakeSumEqual_Prog {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;

		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();

		long sum1 = 0;
		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			q1.offer(queue1[i]);
		}
		long sum2 = 0;
		for (int i = 0; i < queue2.length; i++) {
			sum2 += queue2[i];
			q2.offer(queue2[i]);
		}

		if ((sum1 + sum2) % 2 == 1) {
			answer = -1;
			return answer;
		}

		while (sum1 != sum2) {
			answer++;
			if (sum1 > sum2) {
				int tmp = q1.poll();
				sum1 -= tmp;
				sum2 += tmp;
				q2.offer(tmp);
			} else {
				int tmp = q2.poll();
				sum1 += tmp;
				sum2 -= tmp;
				q1.offer(tmp);
			}
			if (answer > (queue1.length + queue2.length) + (queue1.length / 2)) {
				answer = -1;
				break;
			}
		}

		return answer;
	}
}
