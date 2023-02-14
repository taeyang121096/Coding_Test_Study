package Programmers;

import java.util.*;

public class PerformanceAssessment_Prog {
	public int solution(int[][] scores) {
		int answer = 1;

		int[] wanho = { scores[0][0], scores[0][1] };

		Arrays.sort(scores, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return -1;
				} else if (o1[0] < o2[0]) {
					return 1;
				} else {
					if (o1[1] > o2[1]) {
						return 1;
					} else if (o1[1] < o2[1]) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});

		// for(int i = 0; i < scores.length; i++){
		// System.out.println(scores[i][0] + " " + scores[i][1]);
		// }

		int max = -1;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i][1] < max) {
				if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
					return -1;
				}
				continue;
			}
			max = Math.max(max, scores[i][1]);
			if (scores[i][0] + scores[i][1] > wanho[0] + wanho[1]) {
				answer++;
			}
		}

		return answer;
	}
}
