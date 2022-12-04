package Programmers;

import java.util.*;

public class HideNumAdd_Prog {
	public int solution(String my_string) {
		int answer = 0;
		ArrayList<Integer> al = new ArrayList<>();
		String str = "";
		for (int i = 0; i < my_string.length(); i++) {
			char ch = my_string.charAt(i);
			if (ch >= '0' && ch <= '9') {
				str += ch;
			} else {
				if (str.length() != 0) {
					al.add(Integer.parseInt(str));
					str = "";
				}
			}
		}
		if (str.length() != 0) {
			al.add(Integer.parseInt(str));
		}

		if (al.size() == 0) {
			answer = 0;
		} else {
			for (int i = 0; i < al.size(); i++) {
				answer += al.get(i);
			}
		}

		return answer;
	}
}
