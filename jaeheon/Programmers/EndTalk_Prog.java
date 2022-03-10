package Programmers;

//참여자 n -> 2 ~ 10
//words : 단어들 배열  n ~ 100
//단어 길이 2 ~ 50

import java.util.*;

class EndTalk_Prog {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		int person = 1; // 사람 카운트
		int turn = 1; // 게임 카운트

		ArrayList<String> list = new ArrayList<>();

		char lastIndex = words[0].charAt(0);

		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			if (list.contains(str) || str.charAt(0) != lastIndex) {
				answer[0] = person;
				answer[1] = turn;
				break;
			}

			lastIndex = str.charAt(str.length() - 1);
			System.out.println(lastIndex);
			list.add(str);
			person++;

			if (person > n) { // 턴 반복
				person = 1;
				turn++;
			}
		}

		return answer;
	}
}
