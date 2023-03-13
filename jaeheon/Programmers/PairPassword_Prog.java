package Programmers;

import java.util.*;

public class PairPassword_Prog {
	public String solution(String s, String skip, int index) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int cnt = 0;
			while (cnt < index) {
				ch++;
				if (ch > 'z') {
					ch -= 26;
				}
				if (skip.contains(String.valueOf(ch))) {
					continue;
				}
				cnt++;
			}
			sb.append(ch);
		}

		return sb.toString();
	}
}
