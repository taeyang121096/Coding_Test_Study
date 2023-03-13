package Programmers;

import java.util.*;

public class KeyMap_Prog {
	static Map<Character, Integer> hm;
	static int[] answer;

	public int[] solution(String[] keymap, String[] targets) {
		answer = new int[targets.length];

		hm = new HashMap<>();

		makeMap(keymap);

		find(targets);

		return answer;
	}

	static void find(String[] targets) {
		for (int i = 0; i < targets.length; i++) {
			int cnt = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				char ch = targets[i].charAt(j);
				if (hm.containsKey(ch)) {
					answer[i] += hm.get(ch);
					continue;
				}
				answer[i] = -1;
				break;
			}
		}
	}

	static void makeMap(String[] keymap) {
		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				char ch = keymap[i].charAt(j);
				int idx = keymap[i].indexOf(ch) + 1;
				if (hm.containsKey(ch)) {
					if (hm.get(ch) > idx) {
						hm.put(ch, idx);
					}
					continue;
				}
				hm.put(ch, idx);
			}
		}
	}
}
