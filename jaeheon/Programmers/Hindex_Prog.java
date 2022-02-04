package Programmers;

//입력 : 논문의 입력 개수
//출력 : 배열 원소가 h 이상인 것 리턴
//h이상 인용된 논문이 h편 이상인 h의 최댓값

import java.util.*;

class Hindex_Prog {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {

			int h = citations.length - i;
			if (citations[i] >= h) {
				answer++;
			}
		}

		return answer;
	}
}