package Programmers;

import java.util.*;

public class Dot_Prog {
	public long solution(int k, int d) {
		long answer = 0;

		for (int i = 0; i <= d / k; i++) {
			long y = i * k;
			long x = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(y, 2));
			answer += (x / k);
		}

		answer += d / k + 1;

		return answer;
	}
}
