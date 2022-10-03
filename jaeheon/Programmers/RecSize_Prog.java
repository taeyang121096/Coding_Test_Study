package Programmers;

import java.util.*;

public class RecSize_Prog {
	public int solution(int[][] dots) {
		int answer = 0;

		int minA = 257;
		int minB = 257;
		int maxA = -257;
		int maxB = -257;
		for (int i = 0; i < dots.length; i++) {
			minA = Math.min(minA, dots[i][0]);
			maxA = Math.max(maxA, dots[i][0]);
		}
		for (int i = 0; i < dots.length; i++) {
			minB = Math.min(minB, dots[i][1]);
			maxB = Math.max(maxB, dots[i][1]);
		}

		int a = Math.abs(minA - maxA);
		int b = Math.abs(minB - maxB);

		answer = a * b;
		return answer;
	}
}
