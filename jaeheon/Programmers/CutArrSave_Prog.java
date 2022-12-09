package Programmers;

import java.util.*;

public class CutArrSave_Prog {
	public String[] solution(String my_str, int n) {
		List<String> al = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < my_str.length(); i++) {
			if ((i + 1) % n == 0) {
				sb.append(my_str.charAt(i));
				al.add(sb.toString());
				sb.setLength(0);
			} else {
				if (i == my_str.length() - 1) {
					sb.append(my_str.charAt(i));
					al.add(sb.toString());
				} else {
					sb.append(my_str.charAt(i));
				}
			}
		}

		String[] answer = new String[al.size()];

		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}
}
