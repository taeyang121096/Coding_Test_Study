package Programmers;

import java.util.*;

public class MinRec_Prog {
	public int solution(int[][] sizes) {
		int answer = 0;

		int tmp = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] >= sizes[i][1]) {
				continue;
			} else {
				tmp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = tmp;
			}
		}

		int rowMax = 0;
		int colMax = 0;

		for (int i = 0; i < sizes.length; i++) {
			rowMax = Math.max(rowMax, sizes[i][0]);
			colMax = Math.max(colMax, sizes[i][1]);
		}

		answer = rowMax * colMax;

		return answer;
	}
}
