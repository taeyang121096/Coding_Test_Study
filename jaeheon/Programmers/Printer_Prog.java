package Programmers;

//대기목록에 가장 앞에 있는 것을 꺼냄
//나머지 중 중요도가 높은것이 있으면 꺼낸 것을 가장 마지막으로
//아니라면 꺼낸거 인쇄
//location : 내가 인쇄를 요청한 문서의 위치
//

import java.util.*;

class Printer_Prog {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i : priorities) {
			pq.offer(i);
		}

		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (pq.peek() == priorities[i]) {
					pq.poll();
					answer++;
					if (location == i) {
						return answer;
					}
				}
			}

		}

		return answer;
	}
}