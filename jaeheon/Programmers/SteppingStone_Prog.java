package Programmers;

//distance 1 ~ 10억  rock 1 ~ 50000  
//n : 제거하는 바위 개수  1 ~ rock의 개수
//distance를 기준으로 징검다리를 없애면 

//0   2   11   14   17   21   25
//2   9    3    3    4    4

import java.util.*;

class SteppingStone_Prog {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		int start = 0;
		int end = distance;

		while (end >= start) {
			int mid = (start + end) / 2;
			int rm = 0;
			int src = 0;
			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - src < mid) {
					rm++;
				} else {
					src = rocks[i];
				}
			}
			if (distance - src < mid) {
				rm++;
			}
			if (rm <= n) {
				answer = Math.max(answer, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}
}