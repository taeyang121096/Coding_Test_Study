package Programmers;

import java.util.*;

public class UbakArr_Prog {
	public double[] solution(int k, int[][] ranges) {
		List<Double> al = new ArrayList<>();
		al.add(k * 1.0);
		while (k != 1) {
			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
			al.add(k * 1.0);
		}

		double[] answer = new double[ranges.length];

		for (int i = 0; i < ranges.length; i++) {
			int left = ranges[i][0];
			int right = al.size() - 1 + ranges[i][1];

			if (left == right) {
				answer[i] = 0.0;
			} else if (left > right) {
				answer[i] = -1.0;
			} else {
				double sum = 0.0;
				while (left < right) {
					sum += (al.get(left) + al.get(left + 1)) / 2;
					left++;
				}
				answer[i] = sum;
			}
		}

		return answer;
	}
}
