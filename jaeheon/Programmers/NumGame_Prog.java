package Programmers;

//숫자가 큰 쪽이 승리
//숫자가 더 커야 이길 수 있음

import java.util.*;

public class NumGame_Prog {
	public int solution(int[] A, int[] B) {
		PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());

		int answer = 0;

		for (int i = 0; i < A.length; i++) {
			pqA.offer(A[i]);
			pqB.offer(B[i]);
		}

		while (!pqA.isEmpty()) {
			int a = pqA.poll();
			int b = pqB.peek();
			if (a < b) {
				pqB.poll();
				answer++;
			}
		}
		return answer;
	}
}
