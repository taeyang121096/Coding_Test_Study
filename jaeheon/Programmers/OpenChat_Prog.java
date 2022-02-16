package Programmers;

import java.util.*;

class OpenChat_Prog {
	public String[] solution(String[] record) {
		HashMap<String, String> hm = new HashMap<>();
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (str[0].equals("Enter") || str[0].equals("Change")) {
				hm.put(str[1], str[2]);
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (str[0].equals("Enter")) {
				list.add(hm.get(str[1]) + "님이 들어왔습니다.");
			} else if (str[0].equals("Leave")) {
				list.add(hm.get(str[1]) + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
