package Programmers;

import java.util.*;

public class MBTI_Prog {
	public String solution(String[] survey, int[] choices) {
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> hm = new HashMap<>();
		String[][] type = { { "R", "T" }, { "C", "F" }, { "J", "M" }, { "A", "N" } };
		for (String[] str : type) {
			hm.put(str[0], 0);
			hm.put(str[1], 0);
		}

		for (int i = 0; i < choices.length; i++) {
			String f = survey[i].substring(0, 1);
			String s = survey[i].substring(1);
			if (choices[i] == 1) {
				hm.put(f, hm.get(f) + 3);
			} else if (choices[i] == 2) {
				hm.put(f, hm.get(f) + 2);
			} else if (choices[i] == 3) {
				hm.put(f, hm.get(f) + 1);
			} else if (choices[i] == 4) {
				continue;
			} else if (choices[i] == 5) {
				hm.put(s, hm.get(s) + 1);
			} else if (choices[i] == 6) {
				hm.put(s, hm.get(s) + 2);
			} else if (choices[i] == 7) {
				hm.put(s, hm.get(s) + 3);
			}
		}

		for (int i = 0; i < type.length; i++) {
			if (hm.get(type[i][0]) > hm.get(type[i][1])) {
				sb.append(type[i][0]);
			} else if (hm.get(type[i][0]) < hm.get(type[i][1])) {
				sb.append(type[i][1]);
			} else {
				if (type[i][0].compareTo(type[i][1]) < 0) {
					sb.append(type[i][0]);
				} else {
					sb.append(type[i][1]);
				}
			}
		}

		return sb.toString();
	}
}
