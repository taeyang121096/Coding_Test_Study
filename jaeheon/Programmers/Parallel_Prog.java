package Programmers;

import java.util.*;

public class Parallel_Prog {
	public int solution(int[][] dots) {
		int answer = 0;

		List<Double> al1 = new ArrayList<>();
		List<Double> al2 = new ArrayList<>();

		for (int i = 1; i < 4; i++) {
			al1.add((dots[i][1] - dots[0][1]) / (double) (dots[i][0] - dots[0][0]));
			if (i >= 2) {
				al2.add((dots[i][1] - dots[1][1]) / (double) (dots[i][0] - dots[1][0]));
				if (i == 3) {
					al2.add((dots[i][1] - dots[i - 1][1]) / (double) (dots[i][0] - dots[i - 1][0]));
				}
			}
		}

		for (double d2 : al2) {
			for (double d1 : al1) {
				if (d1 == d2) {
					return 1;
				}
			}
		}

		return answer;
	}
}
