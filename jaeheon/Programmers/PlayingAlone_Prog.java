package Programmers;

import java.util.*;

public class PlayingAlone_Prog {
	public int solution(int[] cards) {
		int answer = 0;

		for (int i = 0; i < cards.length; i++) {
			boolean[] check = new boolean[cards.length + 1];
			int group1 = 0;
			int now1 = i + 1;
			while (true) {
				if (check[now1] == false) {
					check[now1] = true;
					group1++;
					now1 = cards[now1 - 1];
				} else {
					break;
				}
			}
			// System.out.println(group1 + " " + now1);
			int group2 = 0;
			for (int j = 1; j < check.length; j++) {
				int tmp = 0;
				int now2 = j;
				while (true) {
					if (check[now2] == false) {
						check[now2] = true;
						tmp++;
						now2 = cards[now2 - 1];
					} else {
						group2 = Math.max(group2, tmp);
						break;
					}
				}
			}
			answer = Math.max(answer, group1 * group2);
		}

		return answer;
	}
}
