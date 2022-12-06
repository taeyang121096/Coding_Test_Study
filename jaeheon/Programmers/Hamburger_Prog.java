package Programmers;

import java.util.*;

public class Hamburger_Prog {
	public int solution(int[] ingredient) {
		int answer = 0;

		List<Integer> al = new ArrayList<>();

		for (int i = 0; i < ingredient.length; i++) {
			al.add(ingredient[i]);
			if (al.size() >= 4) {
				if (al.get(al.size() - 4) == 1 && al.get(al.size() - 3) == 2 && al.get(al.size() - 2) == 3
						&& al.get(al.size() - 1) == 1) {
					answer++;
					for (int j = 0; j < 4; j++) {
						al.remove(al.size() - 1);
					}
				}
			}
		}
		return answer;
	}
}
