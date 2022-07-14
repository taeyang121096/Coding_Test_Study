package Programmers;
// 총 3번의 기회 -> 3개씩 끊어서 배열로 저장
// s - 1제곱, d - 2제곱, t - 3제곱
// * - 해당점수, 바로 전 2배, # - 해당점수 마이너스 -> 둘다 점수마다 하나씩만 존재
// 배열 마지막에 한번에 더하기

import java.util.*;

public class DartGame_Prog {
	public int solution(String dartResult) {
		int answer = 0;
		String str = "";
		int[] score = new int[3];
		int sdt = 0;
		int idx = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			if (c >= '0' && c <= '9') {
				str += String.valueOf(c);
			} else if (c == 'S' || c == 'D' || c == 'T') {
				sdt = Integer.parseInt(str);
				if (c == 'S') {
					sdt = (int) Math.pow(sdt, 1);
				} else if (c == 'D') {
					sdt = (int) Math.pow(sdt, 2);
				} else if (c == 'T') {
					sdt = (int) Math.pow(sdt, 3);
				}
				score[idx] = sdt;
				idx++;
				str = "";
			} else if (c == '#' || c == '*') {
				if (c == '*') {
					if (idx - 2 >= 0) {
						score[idx - 2] *= 2;
						score[idx - 1] *= 2;
					} else {
						score[idx - 1] *= 2;
					}
				} else {
					score[idx - 1] *= -1;
				}
			}
		}

		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}

		return answer;
	}
}
